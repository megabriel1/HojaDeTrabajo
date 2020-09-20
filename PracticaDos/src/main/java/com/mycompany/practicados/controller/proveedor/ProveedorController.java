
package com.mycompany.practicados.controller.proveedor;


import com.mycompany.practicados.model.Proveedor;
import com.mycompany.practicados.service.ProveedorService;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProveedorController {

    @GetMapping("/proveedor")
    public String get(Model model) {

        model.addAttribute("proveedor", new Proveedor());

        return "proveedor/crear-proveedor";
    }

    @PostMapping("/proveedor/crear")
    public String create(Model model, @Valid @ModelAttribute("proveedor") Proveedor proveedor, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {

            boolean agregado = ProveedorService.agregarProveedor(proveedor);

            if (agregado) {
                model.addAttribute("proveedor", new Proveedor());
                model.addAttribute("mensaje", "El proveedor ha sido creado");
            } else {
                model.addAttribute("mensaje", "El proveedor ya existe");
            }
        }
        return "proveedor/crear-proveedor";
    }

    @GetMapping("/proveedor/codigo/{codigo}")
    public String getByCodigo(Model model, @PathVariable("codigo") String codigo) {

        var proveedor = ProveedorService.buscarProveedor(codigo);

        model.addAttribute("proveedor", proveedor);

        return "proveedor/editar-proveedor";
    }

    @PostMapping("/proveedor/editar")
    public String modificar(Model model, @ModelAttribute("proveedor") Proveedor proveedor, BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {

            boolean editado = ProveedorService.modificarProveedor(proveedor);

            if (editado) {
                model.addAttribute("proveedor", new Proveedor());
                model.addAttribute("mensaje", "El proveedor ha sido modificado");
            } else {
                model.addAttribute("mensaje", "El proveedor ya existe");
            }
        }

        return "proveedor/editar-proveedor";
    }

    @GetMapping("/proveedor/eliminar/{eliminar}")
    public String getEliminar(Model model, @PathVariable("eliminar") String eliminar) {

        var proveedor = ProveedorService.buscarProveedor(eliminar);

        model.addAttribute("proveedor", proveedor);

        return "proveedor/eliminar-proveedor";
    }

    @PostMapping("/proveedor/eliminar")
    public String eliminar(Model model, @ModelAttribute("proveedor") Proveedor proveedor, BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {

            boolean eliminado = ProveedorService.eliminarProveedor(proveedor);

            if (eliminado) {

                model.addAttribute("proveedor", new Proveedor());
                model.addAttribute("mensaje", "El proveedor ha sido eliminado");
            } else {
                model.addAttribute("mensaje", "El proveedor ya existe");
            }
        }
        return "proveedor/eliminar-proveedor";
    }
}
