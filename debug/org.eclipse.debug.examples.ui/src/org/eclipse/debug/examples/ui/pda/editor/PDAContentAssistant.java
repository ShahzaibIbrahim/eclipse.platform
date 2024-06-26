/*******************************************************************************
 * Copyright (c) 2005, 2007 IBM Corporation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Bjorn Freeman-Benson - initial API and implementation
 *******************************************************************************/
package org.eclipse.debug.examples.ui.pda.editor;

import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.contentassist.ContentAssistant;

public class PDAContentAssistant extends ContentAssistant {

	public PDAContentAssistant() {
		super();

		PDAContentAssistProcessor processor= new PDAContentAssistProcessor();
		setContentAssistProcessor(processor, IDocument.DEFAULT_CONTENT_TYPE);

		enableAutoActivation(false);
		enableAutoInsert(false);

		setInformationControlCreator(getInformationControlCreator());
	}

	private IInformationControlCreator getInformationControlCreator() {
		return DefaultInformationControl::new;
	}
}
