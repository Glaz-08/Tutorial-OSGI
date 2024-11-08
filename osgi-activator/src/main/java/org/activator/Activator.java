package org.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {
    @Override
    public void start(BundleContext context) throws Exception {// si inicio en felix aqui es el mensaje que sale al principio
        System.out.println("Hello OSGI World.");
    }

    @Override
    public void stop(BundleContext context) throws Exception {//este es el mensaje que sale en el felix cuando se cierra
        System.out.println("Goodbye OSGI World.");
    }
}
