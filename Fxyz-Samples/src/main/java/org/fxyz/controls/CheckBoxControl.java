/**
* CheckBoxControl.java
*
* Copyright (c) 2013-2015, F(X)yz
* All rights reserved.
*
* Redistribution and use in source and binary forms, with or without
* modification, are permitted provided that the following conditions are met:
* * Redistributions of source code must retain the above copyright
* notice, this list of conditions and the following disclaimer.
* * Redistributions in binary form must reproduce the above copyright
* notice, this list of conditions and the following disclaimer in the
* documentation and/or other materials provided with the distribution.
* * Neither the name of the organization nor the
* names of its contributors may be used to endorse or promote products
* derived from this software without specific prior written permission.
*
* THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
* ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
* WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
* DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
* DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
* (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
* LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
* ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
* (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
* SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package org.fxyz.controls;

import javafx.beans.property.Property;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

/**
 * FXML Controller class
 *
 * @author Jason Pollastrini aka jdub1581
 */
public class CheckBoxControl extends ControlBase<Property<Boolean>>{

    
    public CheckBoxControl(Property<Boolean> prop) {
        super("/org/fxyz/controls/CheckBoxControl.fxml", prop);
        loadBindings();
    }

    @FXML
    private CheckBox checkBox;
    public final void loadBindings() {
        if(controlledProperty==null){
            return;
        }
        checkBox.selectedProperty().addListener(l->{
            if(checkBox != null){
                controlledProperty.setValue(checkBox.isSelected());
            }
        });
        controlledProperty.addListener(l->{
            if(controlledProperty.getValue() != checkBox.isSelected()){
                setSelected(controlledProperty.getValue());
            }
        });
        checkBox.setText(!controlledProperty.getName().isEmpty() ? controlledProperty.getName() : "Empty Name");
    }
    
    public void setSelected(boolean value){
        checkBox.setSelected(value);
    }
    
}