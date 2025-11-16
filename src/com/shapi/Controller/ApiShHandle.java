package com.shapi.Controller;

import com.shapi.Models.auth.Session;
import rsc.Repositores.AuthRepository;
import rsc.Repositores.ClientesRepository.ClienteRepository;
import rsc.Repositores.ConfigRepository;
import rsc.Repositores.PromoRepository;
import rsc.Repositores.UbicacionRepository;
import rsc.Repositores.WorkRepository;
import rsc.Services.AuthService;
import rsc.Services.ConfigService;
import rsc.Services.PromoService;
import rsc.Services.UbicacionService;
import rsc.Services.WorkService;
import rsc.Services.api.ApiServices;
import rsc.Services.ClientesServices.ClientesService;

public final class ApiShHandle implements ApiServices {

    private final AuthService _AuthService = new AuthRepository();
    private final ClientesService _ClienteService = new ClienteRepository();
    private final ConfigService _ConfigService = new ConfigRepository();
    private final PromoService _PromoService = new PromoRepository();
    private final UbicacionService _UbicacionService = new UbicacionRepository();
    private final WorkService _WorkService = new WorkRepository();

    private ApiShHandle() {
    }

    @Override
    public ClientesService clienteService(Session session) {
        return this._ClienteService;
    }

    @Override
    public ConfigService configService() {
        return this._ConfigService;
    }

    @Override
    public PromoService promoService() {
        return this._PromoService;
    }

    @Override
    public UbicacionService ubicacionService() {
        return this._UbicacionService;
    }

    @Override
    public WorkService workService() {
        return this._WorkService;
    }

    @Override
    public AuthService authService() {
        return _AuthService;
    }

    private static class Holder {

        private static final ApiShHandle INSTANCE = new ApiShHandle();
    }

    public static ApiShHandle getInstance() {
        return Holder.INSTANCE;
    }

}
