package com.shapi.Models.Utils;

import java.awt.IllegalComponentStateException;
import java.beans.PropertyChangeListener;
import java.util.Locale;
import javax.accessibility.Accessible;
import javax.accessibility.AccessibleAction;
import javax.accessibility.AccessibleComponent;
import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleEditableText;
import javax.accessibility.AccessibleIcon;
import javax.accessibility.AccessibleRelationSet;
import javax.accessibility.AccessibleRole;
import javax.accessibility.AccessibleSelection;
import javax.accessibility.AccessibleStateSet;
import javax.accessibility.AccessibleTable;
import javax.accessibility.AccessibleText;
import javax.accessibility.AccessibleValue;

public class LimitedAccessibleContext extends AccessibleContext {

    @Override
    public AccessibleRole getAccessibleRole() {
      return null;
    }

    @Override
    public AccessibleStateSet getAccessibleStateSet() {
      return null;

    }

    @Override
    public int getAccessibleIndexInParent() {
            return -1;
    }

    @Override
    public int getAccessibleChildrenCount() {
          return -1;

    }

    @Override
    public Accessible getAccessibleChild(int i) {
           return null;
    }

    @Override
    public Locale getLocale() throws IllegalComponentStateException {
           return null;
    }

    @Override
    public void setAccessibleName(String s) {
        super.setAccessibleName(s); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public void setAccessibleDescription(String s) {
        super.setAccessibleDescription(s); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
   

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
    
    }

    @Override
    public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
    
    }

    public static String getACCESSIBLE_ACTION_PROPERTY() {
             return null;
    }

    public static String getACCESSIBLE_ACTIVE_DESCENDANT_PROPERTY() {
              return null;
    }

    public static String getACCESSIBLE_CARET_PROPERTY() {
             return null;
    }

    public static String getACCESSIBLE_CHILD_PROPERTY() {
          return null;
    }

    public static String getACCESSIBLE_COMPONENT_BOUNDS_CHANGED() {
          return null;
    }

    public static String getACCESSIBLE_DESCRIPTION_PROPERTY() {
          return null;
    }

    public static String getACCESSIBLE_HYPERTEXT_OFFSET() {
         return null;
    }

    public static String getACCESSIBLE_INVALIDATE_CHILDREN() {
         return null;
    }

    public static String getACCESSIBLE_NAME_PROPERTY() {
          return null;
    }

    public static String getACCESSIBLE_SELECTION_PROPERTY() {
          return null;
    }

    public static String getACCESSIBLE_STATE_PROPERTY() {
         return null;
    }

    public static String getACCESSIBLE_TABLE_CAPTION_CHANGED() {
         return null;
    }

    public static String getACCESSIBLE_TABLE_COLUMN_DESCRIPTION_CHANGED() {
          return null;
    }

    public static String getACCESSIBLE_TABLE_COLUMN_HEADER_CHANGED() {
          return null;
    }

    public static String getACCESSIBLE_TABLE_MODEL_CHANGED() {
        return null;
    }

    public static String getACCESSIBLE_TABLE_ROW_DESCRIPTION_CHANGED() {
          return null;
    }

    public static String getACCESSIBLE_TABLE_ROW_HEADER_CHANGED() {
          return null;
    }

    public static String getACCESSIBLE_TABLE_SUMMARY_CHANGED() {
          return null;
    }

    public static String getACCESSIBLE_TEXT_ATTRIBUTES_CHANGED() {
         return null;
    }

    public static String getACCESSIBLE_TEXT_PROPERTY() {
           return null;
    }

    public static String getACCESSIBLE_VALUE_PROPERTY() {
          return null;
    }

    public static String getACCESSIBLE_VISIBLE_DATA_PROPERTY() {
          return null;
    }

    @Override
    public AccessibleAction getAccessibleAction() {
           return null;
    }

    @Override
    public AccessibleComponent getAccessibleComponent() {
           return null;
    }

    @Override
    public AccessibleEditableText getAccessibleEditableText() {
          return null;
    }

    @Override
    public AccessibleIcon[] getAccessibleIcon() {
          return null;
    }

    @Override
    public String getAccessibleName() {
         return super.accessibleDescription;
    }

    @Override
    public String getAccessibleDescription() {
          return super.accessibleDescription;
    }

    @Override
    public Accessible getAccessibleParent() {
          return null;
    }

    @Override
    public AccessibleRelationSet getAccessibleRelationSet() {
          return null;
    }

    @Override
    public AccessibleSelection getAccessibleSelection() {
          return null;
    }

    @Override
    public AccessibleTable getAccessibleTable() {
          return null;
    }

    @Override
    public AccessibleText getAccessibleText() {
          return null;
    }

    @Override
    public AccessibleValue getAccessibleValue() {
          return null;
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        
    }

    @Override
    public void setAccessibleParent(Accessible a) {
   
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
          return null;
    }

}
