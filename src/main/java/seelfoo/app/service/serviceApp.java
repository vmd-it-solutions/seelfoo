package seelfoo.app.service;

import org.springframework.stereotype.Service;
import seelfoo.app.DTO.initData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class serviceApp {
    private static final Map<Long, initData> services = new HashMap<>();

    public initData criar(initData service) {
        Long proximoId = services.keySet().size() + 1L;
        service.setId(proximoId);
        services.put(proximoId, service);
        return service;
    }

    public initData atualizar(initData service, Long serviceId) {
        services.put(serviceId, service);
        return service;
    }

    public initData getById (Long serviceId) {
        return services.get(serviceId);
    }

    public List<initData> getAll () {
        return new ArrayList<>(services.values());
    }

    public String delete (Long serviceId) {
        services.remove(serviceId);
        return "Removed";
    }
}
