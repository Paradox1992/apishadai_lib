package com.shapi.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.requestsupport.responses.ApiResponse;
import com.requestsupport.responses.PaginatedApiResponse;
import com.shapi.model.Farma.Proveedores;
import com.shapi.model.util.ProveedorImageResponse.ImageData;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ModelDeserializationTest {

    private final ObjectMapper mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    @Test
    public void deserializesEveryEntityFromScalarId() throws Exception {
        List<Class<?>> entityTypes = List.of(
                AppModule.class,
                AppModuleStatus.class,
                Customer.class,
                Department.class,
                Device.class,
                DeviceStatus.class,
                HorasLab.class,
                Municipality.class,
                Permission.class,
                Promotion.class,
                PromotionStatus.class,
                Proveedores.class,
                Role.class,
                Stock.class,
                StockStatus.class,
                Ticket.class,
                TimeType.class,
                User.class,
                UserStatus.class,
                View.class,
                ViewAction.class,
                ViewStatus.class,
                WorkShift.class);

        for (Class<?> entityType : entityTypes) {
            Object entity = mapper.readValue("42", entityType);
            Object id = entityType.getMethod("getId").invoke(entity);

            assertEquals(entityType.getSimpleName(), Integer.valueOf(42), id);
        }
    }

    @Test
    public void deserializesDeviceFromObjectIdPartialAndCompleteJson() throws Exception {
        Device idOnly = mapper.readValue("{\"id\":10}", Device.class);
        assertEquals(Integer.valueOf(10), idOnly.getId());

        Device partial = mapper.readValue("""
                {
                    "id": 10,
                    "displayname": "Caja principal"
                }
                """, Device.class);
        assertEquals(Integer.valueOf(10), partial.getId());
        assertEquals("Caja principal", partial.getDisplayname());
        assertNull(partial.getIp());

        Device complete = mapper.readValue("""
                {
                    "id": 10,
                    "ip": "192.168.1.5",
                    "ip2": "192.168.1.6",
                    "name": "PC-CAJA",
                    "displayname": "Caja principal",
                    "stock": {
                        "id": 2,
                        "descripcion": "Talanga",
                        "estado": {
                            "id": 1,
                            "descripcion": "ACTIVO"
                        }
                    },
                    "estado": {
                        "id": 1,
                        "descripcion": "ACTIVO"
                    },
                    "created_at": "2026-08-17T10:15:30-06:00"
                }
                """, Device.class);

        assertEquals(Integer.valueOf(10), complete.getId());
        assertEquals("192.168.1.5", complete.getIp());
        assertEquals(Integer.valueOf(2), complete.getStock().getId());
        assertEquals("Talanga", complete.getStock().getDescripcion());
        assertEquals(Integer.valueOf(1), complete.getStock().getEstado().getId());
        assertEquals(Integer.valueOf(1), complete.getEstado().getId());
        assertNotNull(complete.getCreated_at());
    }

    @Test
    public void deserializesScalarRelationshipsAndKeepsMissingNumbersNull() throws Exception {
        WorkShift workShift = mapper.readValue("""
                {
                    "id": 1,
                    "usuario": 7,
                    "device": {
                        "id": 10,
                        "stock": 3,
                        "estado": 1
                    }
                }
                """, WorkShift.class);

        assertEquals(Integer.valueOf(7), workShift.getUsuario().getId());
        assertEquals(Integer.valueOf(10), workShift.getDevice().getId());
        assertEquals(Integer.valueOf(3), workShift.getDevice().getStock().getId());
        assertEquals(Integer.valueOf(1), workShift.getDevice().getEstado().getId());

        Customer customer = mapper.readValue("{\"id\":5}", Customer.class);
        Promotion promotion = mapper.readValue("{\"id\":6}", Promotion.class);
        Ticket ticket = mapper.readValue("{\"id\":7}", Ticket.class);
        HorasLab horasLab = mapper.readValue("{\"id\":8}", HorasLab.class);

        assertNull(customer.getEdad());
        assertNull(promotion.getImpresiones());
        assertNull(promotion.getValor());
        assertNull(ticket.getNtiket());
        assertNull(horasLab.getHoras_lab());
        assertNull(horasLab.getHoras_lunch());
    }

    @Test
    public void deserializesWorkLunchReportFields() throws Exception {
        WorkShift report = mapper.readValue("""
                {
                    "id": 15,
                    "work_date": "2026-09-01",
                    "usuario": {"id": 7, "nombre": "Operador"},
                    "device": {
                        "id": 10,
                        "displayname": "Caja 1",
                        "stock": {"id": 3, "descripcion": "Sucursal Centro"}
                    },
                    "wkstart_time": "2026-09-01T08:00:00-06:00",
                    "wkend_time": "2026-09-01T17:00:00-06:00",
                    "lunch_start_time": "2026-09-01T12:00:00-06:00",
                    "lunch_end_time": "2026-09-01T13:00:00-06:00"
                }
                """, WorkShift.class);

        assertEquals(java.time.LocalDate.of(2026, 9, 1), report.getWork_date());
        assertEquals("Sucursal Centro", report.getDevice().getStock().getDescripcion());
        assertNotNull(report.getWkstart_time());
        assertNotNull(report.getLunch_end_time());
    }

    @Test
    public void deserializesEntityListsAndIgnoresUnknownResponseFields() throws Exception {
        List<Device> devices = mapper.readValue("""
                [
                    10,
                    {"id": 11, "displayname": "Caja", "future_field": true}
                ]
                """, new TypeReference<List<Device>>() { });

        assertEquals(2, devices.size());
        assertEquals(Integer.valueOf(10), devices.get(0).getId());
        assertEquals(Integer.valueOf(11), devices.get(1).getId());
        assertEquals("Caja", devices.get(1).getDisplayname());

        TicketRequest response = mapper.readValue("""
                {
                    "numero": "0001",
                    "stock": "Talanga",
                    "future_field": "ignored"
                }
                """, TicketRequest.class);

        assertEquals("0001", response.getNumero());
        assertEquals("Talanga", response.getStock());
        assertNull(response.getCliente_n());
    }

    @Test
    public void deserializesIndividualAndListApiResponses() throws Exception {
        JavaType individualType = mapper.getTypeFactory()
                .constructParametricType(ApiResponse.class, Device.class);
        ApiResponse<Device> individual = mapper.readValue("""
                {
                    "message": "ok",
                    "code": 200,
                    "data": {
                        "id": 10,
                        "stock": 3
                    }
                }
                """, individualType);

        assertEquals(Integer.valueOf(10), individual.getData().getId());
        assertEquals(Integer.valueOf(3), individual.getData().getStock().getId());

        JavaType deviceListType = mapper.getTypeFactory()
                .constructCollectionType(List.class, Device.class);
        JavaType paginatedType = mapper.getTypeFactory()
                .constructParametricType(PaginatedApiResponse.class, deviceListType);
        PaginatedApiResponse<List<Device>> paginated = mapper.readValue("""
                {
                    "message": "ok",
                    "code": 200,
                    "data": [
                        10,
                        {"id": 11, "displayname": "Caja"}
                    ]
                }
                """, paginatedType);

        assertEquals(2, paginated.getData().size());
        assertEquals(Integer.valueOf(10), paginated.getData().get(0).getId());
        assertEquals("Caja", paginated.getData().get(1).getDisplayname());
    }

    @Test
    public void deserializesProveedorImageBase64Response() throws Exception {
        JavaType responseType = mapper.getTypeFactory()
                .constructParametricType(ApiResponse.class, ImageData.class);
        ApiResponse<ImageData> response = mapper.readValue("""
                {
                    "message": "ok",
                    "code": 200,
                    "data": {
                        "image": "aW1hZ2VuLWVuLWJhc2U2NA=="
                    }
                }
                """, responseType);

        assertNotNull(response.getData());
        assertEquals("aW1hZ2VuLWVuLWJhc2U2NA==", response.getData().getImage());
    }
}
