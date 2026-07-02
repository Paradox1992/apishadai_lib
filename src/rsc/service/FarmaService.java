package rsc.service;

import com.shapi.model.auth.Session;
import rsc.service.farma.ProveedoresService;

public interface FarmaService {

    ProveedoresService proveedoresService(Session session);

}
