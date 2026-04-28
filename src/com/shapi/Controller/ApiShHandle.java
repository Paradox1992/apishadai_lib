package com.shapi.Controller;

import com.shapi.Models.auth.Session;
import rsc.Repositores.ApiUtilRepository;
import rsc.Repositores.AuthRepository;
import rsc.Repositores.ClientesRepository.ClienteRepository;
import rsc.Repositores.ConfigRepository;
import rsc.Repositores.PromoRepository;
import rsc.Repositores.ReporteRepository;
import rsc.Repositores.UbicacionRepository;
import rsc.Repositores.WorkRepository;
import rsc.Services.ApiUtilsService;
import rsc.Services.AuthService;
import rsc.Services.ConfigService;
import rsc.Services.UbicacionService;
import rsc.Services.WorkService;
import rsc.Services.api.ApiServices;
import rsc.Services.ClientesServices.ClientesService;
import rsc.Services.ReportesService;
import rsc.Services.SorteosService;

public final class ApiShHandle implements ApiServices {

    private final AuthService AUTH_SERVICE = new AuthRepository();
    private final ClientesService CLIENTES_SERVICE = new ClienteRepository();
    private final ConfigService CONFIG_SERVICE = new ConfigRepository();
    private final SorteosService SORTEOS_SERVICE = new PromoRepository();
    private final UbicacionService UBICACION_SERVICE = new UbicacionRepository();
    private final WorkService WORK_LUNCH_SERVICE = new WorkRepository();
    private final ApiUtilsService UTIL_SERVICE = new ApiUtilRepository();
    private final ReportesService REPORTES_SERVICE = new ReporteRepository();

    private ApiShHandle() {
    }

    @Override
    public ClientesService clienteService(Session session) {
        this.CLIENTES_SERVICE.setSession(session);
        return this.CLIENTES_SERVICE;
    }

    @Override
    public ConfigService configService() {
        return this.CONFIG_SERVICE;
    }

    @Override
    public SorteosService sorteosService() {
        return this.SORTEOS_SERVICE;
    }

    @Override
    public UbicacionService ubicacionService() {
        return this.UBICACION_SERVICE;
    }

    @Override
    public WorkService workService() {
        return this.WORK_LUNCH_SERVICE;
    }

    @Override
    public AuthService authService() {
        return AUTH_SERVICE;
    }

    @Override
    public ApiUtilsService UtilService() {
        return this.UTIL_SERVICE;
    }

    @Override
    public ReportesService reportesService() {
        return this.REPORTES_SERVICE;
    }

    private static class Holder {

        private static final ApiShHandle INSTANCE = new ApiShHandle();
    }

    public static ApiShHandle getInstance() {
        return Holder.INSTANCE;
    }

}
