# Catálogos de productos

Los catálogos siguen el patrón existente: modelo en `com.shapi.model.Farma`,
interfaz en `rsc.service.farma`, repositorio en `rsc.repository.farma` y creación
con sesión mediante `ProductoFactory` y `ProductoService`.

`FarmaService` es el módulo principal y expone `productoService()`. Los ocho
catálogos se agrupan en `ProductoService`; proveedores permanece en Farma.

| Catálogo | Modelo | Acceso desde `farmaService().productoService()` |
| --- | --- | --- |
| Unidades | `ProdUnidad` | `prodUnidadService(session)` |
| Estados | `ProdEstado` | `prodEstadoService(session)` |
| Categorías | `ProdCategoria` | `prodCategoriaService(session)` |
| Presentaciones | `FamPresentacion` | `famPresentacionService(session)` |
| Administraciones | `FamAdministracion` | `famAdministracionService(session)` |
| Familias | `Familia` | `familiaService(session)` |
| Concentraciones | `Concentracion` | `concentracionService(session)` |
| Principios activos | `PrincipalActivo` | `principalActivoService(session)` |

```java
var service = ShApiClient.getInstance().farmaService().productoService().prodCategoriaService(session);
var categoria = new ProdCategoria();
categoria.setNombre("Vitaminas");
ApiResponse<Boolean> resultado = service.create(categoria);
```

La sesión debe contener el `AccessibleContext` de la acción correspondiente,
igual que en los demás recursos. Las rutas se resuelven mediante `RouteHelper`;
no se fijan URLs en los repositorios.

`create`, `update` y `delete` retornan `ApiResponse<Boolean>`. `find` retorna el
modelo y los métodos de listado retornan listas tipadas. Para actualizar estos
catálogos se usa `update(id, entity)`: la ruta Laravel es `PUT .../update/{id}`
con ID numérico obligatorio. El ID del cuerpo es opcional; el controlador y la
validación usan siempre el ID de la URL. Solo deben usarse las acciones que publique
el backend; estos catálogos no tienen un endpoint de filtro independiente.

Ejemplo de actualización (con el `AccessibleContext` de la acción configurado
como `PUT:<ruta-del-recurso>/update/{param}`):

```java
var service = ShApiClient.getInstance().farmaService().productoService().familiaService(session);
var familia = new Familia();
familia.setDescripcion("Analgesicos");
familia.setPresentacion(1);
familia.setAdministracion(1);
ApiResponse<Boolean> resultado = service.update(7, familia);
```

`RouteHelper` sustituye `{param}` por `7` y envía el ID en la URL. La acción
de actualización debe publicar el nuevo sufijo `/update/{param}` en los
metadatos que alimentan el `AccessibleContext`.

Los modelos admiten ID escalar, objeto parcial y objeto completo. Se conservan
los nombres JSON del backend, valores numéricos anulables y fechas
`OffsetDateTime`. `Familia` mantiene `presentacion` y `administracion` como IDs y
sus objetos relacionados en `presentacion_detalle` y `administracion_detalle`.
`PrincipalActivo` conserva `concentracion` como ID y `concentracion_detalle`
como objeto. Así los campos que Laravel valida como enteros se serializan como
enteros incluso después de cargar sus relaciones.
