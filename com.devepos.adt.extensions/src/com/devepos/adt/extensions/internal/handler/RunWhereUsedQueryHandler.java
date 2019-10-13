package com.devepos.adt.extensions.internal.handler;

import java.net.URI;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.ui.PlatformUI;

import com.sap.adt.ris.search.ui.AdtRepositorySearchServiceUIFactory;
import com.sap.adt.ris.search.ui.IAdtRepositorySearchServiceUIParameters;
import com.sap.adt.ris.search.ui.IAdtRepositorySearchServiceUIResult;
import com.sap.adt.ris.search.ui.usagereferences.AdtRisUsageReferencesSearchQuery;
import com.sap.adt.ris.search.ui.usagereferences.AdtRisUsageReferencesSearchQueryParameters;
import com.sap.adt.tools.core.model.adtcore.IAdtObjectReference;

/**
 * Command handler for executing a Where Used Query for an ABAP Development
 * Object
 *
 * @author stockbal
 */
public class RunWhereUsedQueryHandler extends AbstractHandler {

	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		// open search dialog to choose ABAP Development object
		final IAdtRepositorySearchServiceUIParameters parameters = AdtRepositorySearchServiceUIFactory
			.createAdtRepositorySearchServiceUIParameters();
		final IAdtRepositorySearchServiceUIResult result = AdtRepositorySearchServiceUIFactory
			.createAdtRepositorySearchServiceUI()
			.openDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), parameters);

		if (result == null) {
			return null;
		}

		final IAdtObjectReference selectedAdtObjRef = result.getFirstSelectedObjectReference();
		final IProject project = result.getSelectedProject();

		final AdtRisUsageReferencesSearchQueryParameters usageSearchParameters = new AdtRisUsageReferencesSearchQueryParameters(
			project, URI.create(selectedAdtObjRef.getUri()));
		final AdtRisUsageReferencesSearchQuery searchQuery = new AdtRisUsageReferencesSearchQuery(usageSearchParameters);
		NewSearchUI.runQueryInBackground(searchQuery);
		return null;
	}

}
