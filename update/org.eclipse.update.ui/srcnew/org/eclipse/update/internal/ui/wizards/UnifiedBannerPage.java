/*******************************************************************************
 * Copyright (c) 2000, 2003 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.update.internal.ui.wizards;
import java.net.URL;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.update.internal.ui.UpdateUIImages;

public abstract class UnifiedBannerPage extends WizardPage {
	private Image bannerImage;
	private boolean bannerVisible = true;
	public UnifiedBannerPage(String name) {
		super(name);
	}
	/**
	 * @see DialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {
		Composite client = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.horizontalSpacing = 10;
		client.setLayout(layout);

		if (bannerVisible) {
			Label label = new Label(client, SWT.NULL);
			label.setLayoutData(new GridData(GridData.VERTICAL_ALIGN_BEGINNING));
			label.setImage(getBannerImage());
		}

		Control contents = createContents(client);
		contents.setLayoutData(new GridData(GridData.FILL_BOTH));
		setControl(client);
	}

	public void setBannerVisible(boolean visible) {
		this.bannerVisible = visible;
	}
	public boolean isBannedVisible() {
		return bannerVisible;
	}

	protected URL getBannerImageURL() {
		return null;
	}
	private Image getBannerImage() {
		URL imageURL = getBannerImageURL();
		Image image = null;
		if (imageURL == null) {
			// use default
			bannerImage =
				UpdateUIImages.DESC_INSTALL_BANNER.createImage();
			image = bannerImage;
		}
		return image;
	}

	public void dispose() {
		if (bannerImage != null) {
			bannerImage.dispose();
		}
		super.dispose();
	}

	protected abstract Control createContents(Composite parent);
}
