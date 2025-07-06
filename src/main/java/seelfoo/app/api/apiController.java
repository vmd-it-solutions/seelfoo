package seelfoo.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import seelfoo.app.DTO.initData;
import seelfoo.app.service.serviceApp;

import java.util.List;

@Controller
@RequestMapping(value = "/service", produces = MediaType.APPLICATION_JSON_VALUE)
public class apiController {
    @Autowired
    private serviceApp callService;

    @PostMapping
    @ResponseBody
    public initData criar(@RequestBody initData valor) {
        return callService.criar(valor);
    }

    @PutMapping("/{serviceId}")
    @ResponseBody
    public initData atualizar(@PathVariable("serviceId") Long serviceId,
                              @RequestBody initData valor) {
        return callService.atualizar(valor, serviceId);
    }

    @GetMapping
    @ResponseBody
    public List<initData> getAll() {
        return callService.getAll();
    }

    @DeleteMapping("/{serviceId}")
    @ResponseBody
    public String deletar(@PathVariable("serviceId") Long serviceId) {
        return callService.delete(serviceId);
    }
}
