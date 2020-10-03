package com.devepos.adt.utilities;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class AdtUtilitiesPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.devepos.adt.utilities.ui"; //$NON-NLS-1$

	// The shared instance
	private static AdtUtilitiesPlugin plugin;

	/**
	 * The constructor
	 */
	public AdtUtilitiesPlugin() {
	}

	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static AdtUtilitiesPlugin getDefault() {
		return plugin;
	}

}
