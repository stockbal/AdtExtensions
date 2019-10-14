package com.devepos.adt.extensions.internal.messages;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "com.devepos.adt.extensions.internal.messages.messages"; //$NON-NLS-1$
	public static String RunWhereUsedQueryHandler_openObjectDialog_xtit;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
