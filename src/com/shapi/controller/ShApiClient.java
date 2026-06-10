package com.shapi.controller;

import com.shapi.model.auth.Session;
import rsc.repository.ApiMetadataRepository;
import rsc.repository.AuthRepository;
import rsc.repository.client.CustomerRepository;
import rsc.repository.ConfigurationRepository;
import rsc.repository.RaffleRepository;
import rsc.repository.ReportRepository;
import rsc.repository.LocationRepository;
import rsc.repository.WorkRepository;
import rsc.service.ApiMetadataService;
import rsc.service.AuthService;
import rsc.service.ConfigurationService;
import rsc.service.LocationService;
import rsc.service.WorkService;
import rsc.service.api.ApiServices;
import rsc.service.client.CustomerService;
import rsc.service.ReportService;
import rsc.service.RaffleService;

public final class ShApiClient implements ApiServices {

    private final AuthService AUTH_SERVICE = new AuthRepository();
    private final CustomerService CLIENTES_SERVICE = new CustomerRepository();
    private final ConfigurationService CONFIG_SERVICE = new ConfigurationRepository();
    private final RaffleService SORTEOS_SERVICE = new RaffleRepository();
    private final LocationService UBICACION_SERVICE = new LocationRepository();
    private final WorkService WORK_LUNCH_SERVICE = new WorkRepository();
    private final ApiMetadataService UTIL_SERVICE = new ApiMetadataRepository();
    private final ReportService REPORTES_SERVICE = new ReportRepository();

    private ShApiClient() {
    }

    @Override
    public CustomerService clienteService(Session session) {
        this.CLIENTES_SERVICE.setSession(session);
        return this.CLIENTES_SERVICE;
    }

    @Override
    public ConfigurationService configService() {
        return this.CONFIG_SERVICE;
    }

    @Override
    public RaffleService sorteosService() {
        return this.SORTEOS_SERVICE;
    }

    @Override
    public LocationService ubicacionService() {
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
    public ApiMetadataService metadataService() {
        return this.UTIL_SERVICE;
    }

    @Override
    public ReportService reportesService() {
        return this.REPORTES_SERVICE;
    }

    private static class Holder {

        private static final ShApiClient INSTANCE = new ShApiClient();
    }

    public static ShApiClient getInstance() {
        return Holder.INSTANCE;
    }

}
