
package com.mycompany.practicados.service;

import com.mycompany.practicados.model.Proveedor;
import java.util.ArrayList;
import java.util.List;


public class ProveedorService {

    public static List<Proveedor> proveedorList = new ArrayList<>();

    public static boolean agregarProveedor(Proveedor proveedor) {

        boolean existe = proveedorList.stream().anyMatch(p -> p.equals(proveedor));

        if (!existe) {
            proveedorList.add(proveedor);
        }
        return !existe;
    }

    public static boolean modificarProveedor(Proveedor proveedor) {

        for (int i = 0; i < proveedorList.size(); i++) {
            if (proveedorList.get(i).getCodigo().equalsIgnoreCase(proveedor.getCodigo())) {

                proveedorList.set(i, proveedor);

                return true;
            }
        }
        return false;
    }          

    public static boolean eliminarProveedor(Proveedor proveedor) {
        for (int i = 0; i < proveedorList.size(); i++) {
            if (proveedorList.get(i).getCodigo().equalsIgnoreCase(proveedor.getCodigo())) {

                proveedorList.remove(proveedor);

                return true;
            }
        }
        return false;
    }       
    
    public static Proveedor buscarProveedor(String codigo) {

        return proveedorList.stream()
                .filter(p -> p.getCodigo().equalsIgnoreCase(codigo))
                .findFirst()
                .orElse(null);
    }
}
