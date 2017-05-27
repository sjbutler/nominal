/*
    Copyright (C) 2013-2015 The Open University
    Copyright (C) 2017 Simon Butler

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
 */

package uk.ac.open.crc.nominal.util;

import java.util.HashSet;
import java.util.Set;

/**
 * A reference of Java library classes that represent actions.
 */
public class GuiActionReference {

    private static final Set<String> actionImplementors;
    private static final Set<String> eventObjectSubclasses;
    
    static {
        actionImplementors = new HashSet<>();
        actionImplementors.add( "AbstractAction" );
        actionImplementors.add( "javax.swing.AbstractAction" );
        actionImplementors.add( "BasicDesktopPaneUI.CloseAction" );
        actionImplementors.add( "javax.swing.plaf.basic.BasicDesktopPaneUI.CloseAction" );
        actionImplementors.add( "CloseAction" );
        actionImplementors.add( "BasicDesktopPaneUI.MaximizeAction" );
        actionImplementors.add( "javax.swing.plaf.basic.BasicDesktopPaneUI.MaximizeAction" );
        actionImplementors.add( "MaximizeAction" );
        actionImplementors.add( "BasicDesktopPaneUI.MinimizeAction" );
        actionImplementors.add( "javax.swing.plaf.basic.BasicDesktopPaneUI.MinimizeAction" );
        actionImplementors.add( "MinimizeAction" );
        actionImplementors.add( "BasicDesktopPaneUI.NavigateAction" );
        actionImplementors.add( "javax.swing.plaf.basic.BasicDesktopPaneUI.NavigateAction" );
        actionImplementors.add( "NavigateAction" );
        actionImplementors.add( "BasicDesktopPaneUI.OpenAction" );
        actionImplementors.add( "javax.swing.plaf.basic.BasicDesktopPaneUI.OpenAction" );
        actionImplementors.add( "OpenAction" );
        actionImplementors.add( "BasicFileChooserUI.ApproveSelectionAction" );
        actionImplementors.add( "javax.swing.plaf.basic.BasicFileChooserUI.ApproveSelectionAction" );
        actionImplementors.add( "ApproveSelectionAction" );
        actionImplementors.add( "BasicFileChooserUI.CancelSelectionAction" );
        actionImplementors.add( "javax.swing.plaf.basic.BasicFileChooserUI.CancelSelectionAction" );
        actionImplementors.add( "CancelSelectionAction" );
        actionImplementors.add( "BasicFileChooserUI.ChangeToParentDirectoryAction" );
        actionImplementors.add( "javax.swing.plaf.basic.BasicFileChooserUI.ChangeToParentDirectoryAction" );
        actionImplementors.add( "ChangeToParentDirectoryAction" );
        actionImplementors.add( "BasicFileChooserUI.GoHomeAction" );
        actionImplementors.add( "javax.swing.plaf.basic.BasicFileChooserUI.GoHomeAction" );
        actionImplementors.add( "GoHomeAction" );
        actionImplementors.add( "BasicFileChooserUI.NewFolderAction" );
        actionImplementors.add( "javax.swing.plaf.basic.BasicFileChooserUI.NewFolderAction" );
        actionImplementors.add( "NewFolderAction" );
        actionImplementors.add( "BasicFileChooserUI.UpdateAction" );
        actionImplementors.add( "javax.swing.plaf.basic.BasicFileChooserUI.UpdateAction" );
        actionImplementors.add( "UpdateAction" );
        actionImplementors.add( "BasicInternalFrameTitlePane.CloseAction" );
        actionImplementors.add( "javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction" );
        actionImplementors.add( "BasicInternalFrameTitlePane.IconifyAction" );
        actionImplementors.add( "IconifyAction" );
        actionImplementors.add( "BasicInternalFrameTitlePane.MaximizeAction" );
        actionImplementors.add( "javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction" );
        actionImplementors.add( "BasicInternalFrameTitlePane.MoveAction" );
        actionImplementors.add( "javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction" );
        actionImplementors.add( "MoveAction" );
        actionImplementors.add( "BasicInternalFrameTitlePane.RestoreAction" );
        actionImplementors.add( "javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction" );
        actionImplementors.add( "RestoreAction" );
        actionImplementors.add( "BasicInternalFrameTitlePane.SizeAction" );
        actionImplementors.add( "javax.swing.plaf.basic.BasicInternalFrameTitlePane.SizeAction" );
        actionImplementors.add( "SizeAction" );
        actionImplementors.add( "BasicSliderUI.ActionScroller" );
        actionImplementors.add( "javax.swing.plaf.basic.BasicSliderUI.ActionScroller" );
        actionImplementors.add( "ActionScroller" );
        actionImplementors.add( "BasicTreeUI.TreeCancelEditingAction" );
        actionImplementors.add( "javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction" );
        actionImplementors.add( "TreeCancelEditingAction" );
        actionImplementors.add( "BasicTreeUI.TreeHomeAction" );
        actionImplementors.add( "javax.swing.plaf.basic.BasicTreeUI.TreeHomeAction" );
        actionImplementors.add( "TreeHomeAction" );
        actionImplementors.add( "BasicTreeUI.TreeIncrementAction" );
        actionImplementors.add( "TreeIncrementAction" );
        actionImplementors.add( "BasicTreeUI.TreePageAction" );
        actionImplementors.add( "javax.swing.plaf.basic.BasicTreeUI.TreePageAction" );
        actionImplementors.add( "TreePageAction" );
        actionImplementors.add( "BasicTreeUI.TreeToggleAction" );
        actionImplementors.add( "javax.swing.plaf.basic.BasicTreeUI.TreeToggleAction" );
        actionImplementors.add( "TreeToggleAction" );
        actionImplementors.add( "BasicTreeUI.TreeTraverseAction" );
        actionImplementors.add( "javax.swing.plaf.basic.BasicTreeUI.TreeTraverseAction" );
        actionImplementors.add( "TreeTraverseAction" );
        actionImplementors.add( "DefaultEditorKit.BeepAction" );
        actionImplementors.add( "javax.swing.text.DefaultEditorKit.BeepAction" );
        actionImplementors.add( "BeepAction" );
        actionImplementors.add( "DefaultEditorKit.CopyAction" );
        actionImplementors.add( "javax.swing.text.DefaultEditorKit.CopyAction" );
        actionImplementors.add( "CopyAction" );
        actionImplementors.add( "DefaultEditorKit.CutAction" );
        actionImplementors.add( "javax.swing.text.DefaultEditorKit.CutAction" );
        actionImplementors.add( "CutAction" );
        actionImplementors.add( "DefaultEditorKit.DefaultKeyTypedAction" );
        actionImplementors.add( "javax.swing.text.DefaultEditorKit.DefaultKeyTypedAction" );
        actionImplementors.add( "DefaultKeyTypedAction" );
        actionImplementors.add( "DefaultEditorKit.InsertBreakAction" );
        actionImplementors.add( "javax.swing.text.DefaultEditorKit.InsertBreakAction" );
        actionImplementors.add( "InsertBreakAction" );
        actionImplementors.add( "DefaultEditorKit.InsertContentAction" );
        actionImplementors.add( "javax.swing.text.DefaultEditorKit.InsertContentAction" );
        actionImplementors.add( "InsertContentAction" );
        actionImplementors.add( "DefaultEditorKit.InsertTabAction" );
        actionImplementors.add( "javax.swing.text.DefaultEditorKit.InsertTabAction" );
        actionImplementors.add( "InsertTabAction" );
        actionImplementors.add( "DefaultEditorKit.PasteAction" );
        actionImplementors.add( "javax.swing.text.DefaultEditorKit.PasteAction" );
        actionImplementors.add( "PasteAction" );
        actionImplementors.add( "HTMLEditorKit.HTMLTextAction" );
        actionImplementors.add( "javax.swing.text.html.HTMLEditorKit.HTMLTextAction" );
        actionImplementors.add( "HTMLTextAction" );
        actionImplementors.add( "HTMLEditorKit.InsertHTMLTextAction" );
        actionImplementors.add( "javax.swing.text.html.HTMLEditorKit.InsertHTMLTextAction" );
        actionImplementors.add( "InsertHTMLTextAction" );
        actionImplementors.add( "MetalFileChooserUI.DirectoryComboBoxAction" );
        actionImplementors.add( "javax.swing.plaf.metal.MetalFileChooserUI.DirectoryComboBoxAction" );
        actionImplementors.add( "DirectoryComboBoxAction" );
        actionImplementors.add( "StyledEditorKit.AlignmentAction" );
        actionImplementors.add( "javax.swing.text.StyledEditorKit.AlignmentAction" );
        actionImplementors.add( "AlignmentAction" );
        actionImplementors.add( "StyledEditorKit.BoldAction" );
        actionImplementors.add( "javax.swing.text.StyledEditorKit.BoldAction" );
        actionImplementors.add( "BoldAction" );
        actionImplementors.add( "StyledEditorKit.FontFamilyAction" );
        actionImplementors.add( "javax.swing.text.StyledEditorKit.FontFamilyAction" );
        actionImplementors.add( "FontFamilyAction" );
        actionImplementors.add( "StyledEditorKit.FontSizeAction" );
        actionImplementors.add( "javax.swing.text.StyledEditorKit.FontSizeAction" );
        actionImplementors.add( "FontSizeAction" );
        actionImplementors.add( "StyledEditorKit.ForegroundAction" );
        actionImplementors.add( "javax.swing.text.StyledEditorKit.ForegroundAction" );
        actionImplementors.add( "ForegroundAction" );
        actionImplementors.add( "StyledEditorKit.ItalicAction" );
        actionImplementors.add( "javax.swing.text.StyledEditorKit.ItalicAction" );
        actionImplementors.add( "ItalicAction" );
        actionImplementors.add( "StyledEditorKit.StyledTextAction" );
        actionImplementors.add( "javax.swing.text.StyledEditorKit.StyledTextAction" );
        actionImplementors.add( "StyledTextAction" );
        actionImplementors.add( "StyledEditorKit.UnderlineAction" );
        actionImplementors.add( "javax.swing.text.StyledEditorKit.UnderlineAction" );
        actionImplementors.add( "UnderlineAction" );
        actionImplementors.add( "TextAction" );
        actionImplementors.add( "javax.swing.text.TextAction" );
        
        eventObjectSubclasses = new HashSet<>();
        eventObjectSubclasses.add( "AWTEvent" );
        eventObjectSubclasses.add( "java.awt.AWTEvent" );
        eventObjectSubclasses.add( "BeanContextEvent" );
        eventObjectSubclasses.add( "java.beans.beancontext.BeanContextEvent" );
        eventObjectSubclasses.add( "CaretEvent" );
        eventObjectSubclasses.add( "javax.swing.event.CaretEvent" );
        eventObjectSubclasses.add( "ChangeEvent" );
        eventObjectSubclasses.add( "javax.swing.event.ChangeEvent" );
        eventObjectSubclasses.add( "ConnectionEvent" );
        eventObjectSubclasses.add( "javax.sql.ConnectionEvent" );
        eventObjectSubclasses.add( "DragGestureEvent" );
        eventObjectSubclasses.add( "java.awt.dnd.DragGestureEvent" );
        eventObjectSubclasses.add( "DragSourceEvent" );
        eventObjectSubclasses.add( "java.awt.dnd.DragSourceEvent" );
        eventObjectSubclasses.add( "DropTargetEvent" );
        eventObjectSubclasses.add( "java.awt.dnd.DropTargetEvent" );
        eventObjectSubclasses.add( "FlavorEvent" );
        eventObjectSubclasses.add( "java.awt.datatransfer.FlavorEvent" );
        eventObjectSubclasses.add( "HandshakeCompletedEvent" );
        eventObjectSubclasses.add( "javax.net.ssl.HandshakeCompletedEvent" );
        eventObjectSubclasses.add( "HyperlinkEvent" );
        eventObjectSubclasses.add( "javax.swing.event.HyperlinkEvent" );
        eventObjectSubclasses.add( "LineEvent" );
        eventObjectSubclasses.add( "javax.sound.sampled.LineEvent" );
        eventObjectSubclasses.add( "ListDataEvent" );
        eventObjectSubclasses.add( "javax.swing.event.ListDataEvent" );
        eventObjectSubclasses.add( "ListSelectionEvent" );
        eventObjectSubclasses.add( "javax.swing.event.ListSelectionEvent" );
        eventObjectSubclasses.add( "MenuEvent" );
        eventObjectSubclasses.add( "javax.swing.event.MenuEvent" );
        eventObjectSubclasses.add( "NamingEvent" );
        eventObjectSubclasses.add( "javax.naming.event.NamingEvent" );
        eventObjectSubclasses.add( "NamingExceptionEvent" );
        eventObjectSubclasses.add( "javax.naming.event.NamingExceptionEvent" );
        eventObjectSubclasses.add( "NodeChangeEvent" );
        eventObjectSubclasses.add( "java.util.prefs.NodeChangeEvent" );
        eventObjectSubclasses.add( "Notification" );
        eventObjectSubclasses.add( "javax.management.Notification" );
        eventObjectSubclasses.add( "PopupMenuEvent" );
        eventObjectSubclasses.add( "javax.swing.event.PopupMenuEvent" );
        eventObjectSubclasses.add( "PreferenceChangeEvent" );
        eventObjectSubclasses.add( "java.util.prefs.PreferenceChangeEvent" );
        eventObjectSubclasses.add( "PrintEvent" );
        eventObjectSubclasses.add( "javax.print.event.PrintEvent" );
        eventObjectSubclasses.add( "PropertyChangeEvent" );
        eventObjectSubclasses.add( "java.beans.PropertyChangeEvent" );
        eventObjectSubclasses.add( "RowSetEvent" );
        eventObjectSubclasses.add( "javax.sql.RowSetEvent" );
        eventObjectSubclasses.add( "RowSorterEvent" );
        eventObjectSubclasses.add( "javax.swing.event.RowSorterEvent" );
        eventObjectSubclasses.add( "SSLSessionBindingEvent" );
        eventObjectSubclasses.add( "javax.net.ssl.SSLSessionBindingEvent" );
        eventObjectSubclasses.add( "StatementEvent" );
        eventObjectSubclasses.add( "javax.sql.StatementEvent" );
        eventObjectSubclasses.add( "TableColumnModelEvent" );
        eventObjectSubclasses.add( "javax.swing.event.TableColumnModelEvent" );
        eventObjectSubclasses.add( "TableModelEvent" );
        eventObjectSubclasses.add( "javax.swing.event.TableModelEvent" );
        eventObjectSubclasses.add( "TreeExpansionEvent" );
        eventObjectSubclasses.add( "javax.swing.event.TreeExpansionEvent" );
        eventObjectSubclasses.add( "TreeModelEvent" );
        eventObjectSubclasses.add( "javax.swing.event.TreeModelEvent" );
        eventObjectSubclasses.add( "TreeSelectionEvent" );
        eventObjectSubclasses.add( "javax.swing.event.TreeSelectionEvent" );
        eventObjectSubclasses.add( "UndoableEditEvent" );
        eventObjectSubclasses.add( "javax.swing.event.UndoableEditEvent" );
        eventObjectSubclasses.add( "UnsolicitedNotificationEvent" );
        eventObjectSubclasses.add( "javax.naming.ldap.UnsolicitedNotificationEvent" );
        eventObjectSubclasses.add( "ActionEvent" );
        eventObjectSubclasses.add( "java.awt.event.ActionEvent" );
        eventObjectSubclasses.add( "AdjustmentEvent" );
        eventObjectSubclasses.add( "java.awt.event.AdjustmentEvent" );
        eventObjectSubclasses.add( "AncestorEvent" );
        eventObjectSubclasses.add( "javax.swing.event.AncestorEvent" );
        eventObjectSubclasses.add( "ComponentEvent" );
        eventObjectSubclasses.add( "java.awt.event.ComponentEvent" );
        eventObjectSubclasses.add( "HierarchyEvent" );
        eventObjectSubclasses.add( "java.awt.event.HierarchyEvent" );
        eventObjectSubclasses.add( "InputMethodEvent" );
        eventObjectSubclasses.add( "java.awt.event.InputMethodEvent" );
        eventObjectSubclasses.add( "InternalFrameEvent" );
        eventObjectSubclasses.add( "javax.swing.event.InternalFrameEvent" );
        eventObjectSubclasses.add( "InvocationEvent" );
        eventObjectSubclasses.add( "java.awt.event.InvocationEvent" );
        eventObjectSubclasses.add( "ItemEvent" );
        eventObjectSubclasses.add( "java.awt.event.ItemEvent" );
        eventObjectSubclasses.add( "TextEvent" );
        eventObjectSubclasses.add( "java.awt.event.TextEvent" );
        eventObjectSubclasses.add( "BeanContextMembershipEvent" );
        eventObjectSubclasses.add( "java.beans.beancontext.BeanContextMembershipEvent" );
        eventObjectSubclasses.add( "BeanContextServiceAvailableEvent" );
        eventObjectSubclasses.add( "java.beans.beancontext.BeanContextServiceAvailableEvent" );
        eventObjectSubclasses.add( "BeanContextServiceRevokedEvent" );
        eventObjectSubclasses.add( "java.beans.beancontext.BeanContextServiceRevokedEvent" );
        eventObjectSubclasses.add( "DragSourceDragEvent" );
        eventObjectSubclasses.add( "java.awt.dnd.DragSourceDragEvent" );
        eventObjectSubclasses.add( "DragSourceDropEvent" );
        eventObjectSubclasses.add( "java.awt.dnd.DragSourceDropEvent" );
        eventObjectSubclasses.add( "DropTargetDragEvent" );
        eventObjectSubclasses.add( "java.awt.dnd.DropTargetDragEvent" );
        eventObjectSubclasses.add( "DropTargetDropEvent" );
        eventObjectSubclasses.add( "java.awt.dnd.DropTargetDropEvent" );
        eventObjectSubclasses.add( "HTMLFrameHyperlinkEvent" );
        eventObjectSubclasses.add( "javax.swing.text.html.HTMLFrameHyperlinkEvent" );
        eventObjectSubclasses.add( "AttributeChangeNotification" );
        eventObjectSubclasses.add( "javax.management.AttributeChangeNotification" );
        eventObjectSubclasses.add( "JMXConnectionNotification" );
        eventObjectSubclasses.add( "javax.management.remote.JMXConnectionNotification" );
        eventObjectSubclasses.add( "MBeanServerNotification" );
        eventObjectSubclasses.add( "javax.management.MBeanServerNotification" );
        eventObjectSubclasses.add( "MonitorNotification" );
        eventObjectSubclasses.add( "javax.management.monitor.MonitorNotification" );
        eventObjectSubclasses.add( "RelationNotification" );
        eventObjectSubclasses.add( "javax.management.relation.RelationNotification" );
        eventObjectSubclasses.add( "TimerNotification" );
        eventObjectSubclasses.add( "javax.management.timer.TimerNotification" );
        eventObjectSubclasses.add( "PrintJobAttributeEvent" );
        eventObjectSubclasses.add( "javax.print.event.PrintJobAttributeEvent" );
        eventObjectSubclasses.add( "PrintJobEvent" );
        eventObjectSubclasses.add( "javax.print.event.PrintJobEvent" );
        eventObjectSubclasses.add( "PrintServiceAttributeEvent" );
        eventObjectSubclasses.add( "javax.print.event.PrintServiceAttributeEvent" );
        eventObjectSubclasses.add( "IndexedPropertyChangeEvent" );
        eventObjectSubclasses.add( "java.beans.IndexedPropertyChangeEvent" );
 
    }

    public static boolean isAction( String s ) {
        return actionImplementors.contains( s )
                || eventObjectSubclasses.contains( s );
    }
    
    private GuiActionReference() {}
}
