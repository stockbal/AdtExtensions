package com.devepos.adt.extensions;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class AdtExtensionsPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.devepos.adt.extensions"; //$NON-NLS-1$

	// The shared instance
	private static AdtExtensionsPlugin plugin;
	
	/**
	 * The constructor
	 */
	public AdtExtensionsPlugin() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static AdtExtensionsPlugin getDefault() {
		return plugin;
	}

}
