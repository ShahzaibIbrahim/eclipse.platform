/*******************************************************************************
 * Copyright (c) 2018 Remain Software
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     wim.jongman@remainsoftware.com - initial API and implementation
 *******************************************************************************/
package org.eclipse.tips.ide.internal.provider;

import java.util.Date;

import org.eclipse.tips.core.IHtmlTip;
import org.eclipse.tips.core.Tip;
import org.eclipse.tips.core.TipImage;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class Tip2_StartingTips extends Tip implements IHtmlTip {

	public Tip2_StartingTips(String providerId) {
		super(providerId);
	}

	@Override
	public Date getCreationDate() {
		return TipsTipProvider.getDateFromYYMMDD("09/01/2019");
	}

	@Override
	public String getSubject() {
		return "Opening the Tips Dialog";
	}

	@Override
	public String getHTML() {
		return "<h2>Opening the Tips Dialog</h2>The tips are started automatically at startup if there are tips available."
				+ " In case the tips are not loaded at startup you can activate the tips manually from the Help menu."
				+ "<br><br>" + "Press <b><i>Next Tip</i></b> to learn more.<br><br>";
	}

	private TipImage fImage;

	@Override
	public TipImage getImage() {
		if (fImage == null) {
			try {
				Bundle bundle = FrameworkUtil.getBundle(getClass());
				fImage = new TipImage(bundle.getEntry("images/tips/starttip.gif")).setAspectRatio(780, 430, true);
			} catch (Exception e) {
//				getProvider().getManager().log(LogUtil.info(getClass(), e));
			}
		}
		return fImage;
	}

}