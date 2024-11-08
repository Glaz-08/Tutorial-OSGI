package org.client;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.service.definition.ProductService;

public class Client implements BundleActivator {
    @Override
    public void start(BundleContext context) throws Exception {
        ServiceReference<ProductService> serviceReference =
                context.getServiceReference(ProductService.class);//referenciamos un servicio

        if (serviceReference != null) {
            ProductService productService = context.getService(serviceReference);

            boolean productExists = productService.checkProductExists("Laptop");

            if (productExists) {
                System.out.println("Client bundle: 'Laptop' is available.");
            } else {
                System.out.println("Client bundle: 'Laptop' is not available");
            }

            context.ungetService(serviceReference);//liberar el servicio
        } else {
            System.out.println("Client bundle: ProductService not found.");// es si no existiera el servicio
        }
    }

    @Override
    public void stop(BundleContext context) throws Exception {

        System.out.println("Client bundle is stopping...");
    }
}
