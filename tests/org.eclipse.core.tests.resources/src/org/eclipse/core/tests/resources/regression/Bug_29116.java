/**********************************************************************
 * Copyright (c) 2003 IBM Corporation and others. All rights reserved.   This
 * program and the accompanying materials are made available under the terms of
 * the Common Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors: 
 * IBM - Initial API and implementation
 **********************************************************************/
package org.eclipse.core.tests.resources.regression;

import junit.framework.Test;
import junit.framework.TestSuite;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.tests.harness.EclipseWorkspaceTest;

/**
 * Test regression of bug 29116.  In this bug, triggering a builder during
 * installation of a nature caused an assertion failure.
 */
public class Bug_29116 extends EclipseWorkspaceTest {
	public Bug_29116() {
		super();
	}
	public Bug_29116(String name) {
		super(name);
	}
	public static Test suite() {
		return new TestSuite(Bug_29116.class);
	}
	public void testBug() {
		// Create some resource handles
		IProject project = getWorkspace().getRoot().getProject("PROJECT");
	
		try {
			// Create and open a project
			project.create(getMonitor());
			project.open(getMonitor());
		} catch (CoreException e) {
			fail("1.0", e);
		}

		// Create and set a build spec for the project
		try {
			IProjectDescription desc = project.getDescription();
			desc.setNatureIds(new String[] {NATURE_29116});
			project.setDescription(desc, getMonitor());
		} catch (CoreException e) {
			fail("2.0", e);
		}
	}

}
