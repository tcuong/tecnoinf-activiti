/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.explorer.ui.form;

import org.activiti.engine.form.FormProperty;

import com.vaadin.ui.Field;
import com.vaadin.ui.Label;

/**
 * @author Brus
 */
public class LabelFormPropertyRenderer extends AbstractFormPropertyRenderer {

	public LabelFormPropertyRenderer() {
		super(ComboFormType.class);
	}

	@Override
	public Field getPropertyField(FormProperty formProperty) {
		
		System.out.println(formProperty.getValue());;
		Label richText = new Label(
                "<h1>Rich text example</h1>"
                        + "<p>The <b>quick</b> brown fox jumps <sup>over</sup> the <b>lazy</b> dog.</p>"
                        + "<p>This text can be edited with the <i>Edit</i> -button</p>");
        richText.setContentMode(Label.CONTENT_XHTML);
        
		return (Field) richText;
	}

}
