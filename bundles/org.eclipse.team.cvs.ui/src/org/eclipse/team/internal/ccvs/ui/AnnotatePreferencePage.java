/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.team.internal.ccvs.ui;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.*;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.*;

public class AnnotatePreferencePage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	private RadioGroupFieldEditor binaryPrompt = null;

	public AnnotatePreferencePage() {
		super(GRID);
		setTitle(CVSUIMessages.AnnotatePreferencePage_AnnotatePrefPageTitle);
		setDescription(CVSUIMessages.AnnotatePreferencePage_AnnotatePrefPageMessage);
		setPreferenceStore(CVSUIPlugin.getPlugin().getPreferenceStore());
	}

	public void createControl(Composite parent) {
		super.createControl(parent);
		// set F1 help
		PlatformUI.getWorkbench().getHelpSystem().setHelp(getControl(), IHelpContextIds.ANNOTATE_VIEW);
	}

	public void createFieldEditors() {
		binaryPrompt = new RadioGroupFieldEditor(ICVSUIConstants.PREF_ANNOTATE_PROMPTFORBINARY, CVSUIMessages.AnnotatePreferencePage_AnnotatePrefPageBinaryFileMessage, 3, new String[][] { {CVSUIMessages.CVSPreferencesPage_11, MessageDialogWithToggle.ALWAYS}, {CVSUIMessages.CVSPreferencesPage_12, MessageDialogWithToggle.NEVER}, {CVSUIMessages.CVSPreferencesPage_13, MessageDialogWithToggle.PROMPT}}, getFieldEditorParent(), true /* use a group */);
		addField(binaryPrompt);

		Dialog.applyDialogFont(getFieldEditorParent());
		getFieldEditorParent().layout(true);
	}

	public void init(IWorkbench workbench) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.preference.IPreferencePage#performOk()
	 */
	public boolean performOk() {
		CVSUIPlugin.getPlugin().savePluginPreferences();
		return super.performOk();
	}
}
