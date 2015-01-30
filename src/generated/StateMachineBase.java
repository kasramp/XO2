/**
 * This class contains generated code from the Codename One Designer, DO NOT MODIFY!
 * This class is designed for subclassing that way the code generator can overwrite it
 * anytime without erasing your changes which should exist in a subclass!
 * For details about this file and how it works please read this blog post:
 * http://codenameone.blogspot.com/2010/10/ui-builder-class-how-to-actually-use.html
*/
package generated;

import com.codename1.ui.*;
import com.codename1.ui.util.*;
import com.codename1.ui.plaf.*;
import java.util.Hashtable;
import com.codename1.ui.events.*;

public abstract class StateMachineBase extends UIBuilder {
    private Container aboutToShowThisContainer;
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    /**
    * @deprecated use the version that accepts a resource as an argument instead
    
**/
    protected void initVars() {}

    protected void initVars(Resources res) {}

    public StateMachineBase(Resources res, String resPath, boolean loadTheme) {
        startApp(res, resPath, loadTheme);
    }

    public Container startApp(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("RadioButton", com.codename1.ui.RadioButton.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("SpanLabel", com.codename1.components.SpanLabel.class);
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    if(resPath.endsWith(".res")) {
                        res = Resources.open(resPath);
                        System.out.println("Warning: you should construct the state machine without the .res extension to allow theme overlays");
                    } else {
                        res = Resources.openLayered(resPath);
                    }
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        if(res != null) {
            setResourceFilePath(resPath);
            setResourceFile(res);
            initVars(res);
            return showForm(getFirstFormName(), null);
        } else {
            Form f = (Form)createContainer(resPath, getFirstFormName());
            initVars(fetchResourceFile());
            beforeShow(f);
            f.show();
            postShow(f);
            return f;
        }
    }

    protected String getFirstFormName() {
        return "First";
    }

    public Container createWidget(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("RadioButton", com.codename1.ui.RadioButton.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("SpanLabel", com.codename1.components.SpanLabel.class);
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    res = Resources.openLayered(resPath);
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        return createContainer(resPath, "First");
    }

    protected void initTheme(Resources res) {
            String[] themes = res.getThemeResourceNames();
            if(themes != null && themes.length > 0) {
                UIManager.getInstance().setThemeProps(res.getTheme(themes[0]));
            }
    }

    public StateMachineBase() {
    }

    public StateMachineBase(String resPath) {
        this(null, resPath, true);
    }

    public StateMachineBase(Resources res) {
        this(res, null, true);
    }

    public StateMachineBase(String resPath, boolean loadTheme) {
        this(null, resPath, loadTheme);
    }

    public StateMachineBase(Resources res, boolean loadTheme) {
        this(res, null, loadTheme);
    }

    public com.codename1.ui.Button findButton8(Component root) {
        return (com.codename1.ui.Button)findByName("Button8", root);
    }

    public com.codename1.ui.Button findButton8() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button8", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button8", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer3(Component root) {
        return (com.codename1.ui.Container)findByName("Container3", root);
    }

    public com.codename1.ui.Container findContainer3() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container3", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer2(Component root) {
        return (com.codename1.ui.Container)findByName("Container2", root);
    }

    public com.codename1.ui.Container findContainer2() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton7(Component root) {
        return (com.codename1.ui.Button)findByName("Button7", root);
    }

    public com.codename1.ui.Button findButton7() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button7", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button7", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer1(Component root) {
        return (com.codename1.ui.Container)findByName("Container1", root);
    }

    public com.codename1.ui.Container findContainer1() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton6(Component root) {
        return (com.codename1.ui.Button)findByName("Button6", root);
    }

    public com.codename1.ui.Button findButton6() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button6", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button6", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton5(Component root) {
        return (com.codename1.ui.Button)findByName("Button5", root);
    }

    public com.codename1.ui.Button findButton5() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button5", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button5", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.RadioButton findRadioButton(Component root) {
        return (com.codename1.ui.RadioButton)findByName("RadioButton", root);
    }

    public com.codename1.ui.RadioButton findRadioButton() {
        com.codename1.ui.RadioButton cmp = (com.codename1.ui.RadioButton)findByName("RadioButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.RadioButton)findByName("RadioButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton4(Component root) {
        return (com.codename1.ui.Button)findByName("Button4", root);
    }

    public com.codename1.ui.Button findButton4() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button4", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button4", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton3(Component root) {
        return (com.codename1.ui.Button)findByName("Button3", root);
    }

    public com.codename1.ui.Button findButton3() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button3", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton2(Component root) {
        return (com.codename1.ui.Button)findByName("Button2", root);
    }

    public com.codename1.ui.Button findButton2() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton(Component root) {
        return (com.codename1.ui.Button)findByName("Button", root);
    }

    public com.codename1.ui.Button findButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel1(Component root) {
        return (com.codename1.ui.Label)findByName("Label1", root);
    }

    public com.codename1.ui.Label findLabel1() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.RadioButton findRadioButton3(Component root) {
        return (com.codename1.ui.RadioButton)findByName("RadioButton3", root);
    }

    public com.codename1.ui.RadioButton findRadioButton3() {
        com.codename1.ui.RadioButton cmp = (com.codename1.ui.RadioButton)findByName("RadioButton3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.RadioButton)findByName("RadioButton3", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.RadioButton findRadioButton1(Component root) {
        return (com.codename1.ui.RadioButton)findByName("RadioButton1", root);
    }

    public com.codename1.ui.RadioButton findRadioButton1() {
        com.codename1.ui.RadioButton cmp = (com.codename1.ui.RadioButton)findByName("RadioButton1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.RadioButton)findByName("RadioButton1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel(Component root) {
        return (com.codename1.ui.Label)findByName("Label", root);
    }

    public com.codename1.ui.Label findLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.RadioButton findRadioButton2(Component root) {
        return (com.codename1.ui.RadioButton)findByName("RadioButton2", root);
    }

    public com.codename1.ui.RadioButton findRadioButton2() {
        com.codename1.ui.RadioButton cmp = (com.codename1.ui.RadioButton)findByName("RadioButton2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.RadioButton)findByName("RadioButton2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findButton1(Component root) {
        return (com.codename1.ui.Button)findByName("Button1", root);
    }

    public com.codename1.ui.Button findButton1() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("Button1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("Button1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.components.SpanLabel findSpanLabel(Component root) {
        return (com.codename1.components.SpanLabel)findByName("SpanLabel", root);
    }

    public com.codename1.components.SpanLabel findSpanLabel() {
        com.codename1.components.SpanLabel cmp = (com.codename1.components.SpanLabel)findByName("SpanLabel", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.components.SpanLabel)findByName("SpanLabel", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.components.SpanLabel findSpanLabel1(Component root) {
        return (com.codename1.components.SpanLabel)findByName("SpanLabel1", root);
    }

    public com.codename1.components.SpanLabel findSpanLabel1() {
        com.codename1.components.SpanLabel cmp = (com.codename1.components.SpanLabel)findByName("SpanLabel1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.components.SpanLabel)findByName("SpanLabel1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer(Component root) {
        return (com.codename1.ui.Container)findByName("Container", root);
    }

    public com.codename1.ui.Container findContainer() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container", aboutToShowThisContainer);
        }
        return cmp;
    }

    public static final int COMMAND_SecondCommand2 = 2;
    public static final int COMMAND_FirstCancel = 1;

    protected boolean onSecondCommand2() {
        return false;
    }

    protected boolean onFirstCancel() {
        return false;
    }

    protected void processCommand(ActionEvent ev, Command cmd) {
        switch(cmd.getId()) {
            case COMMAND_SecondCommand2:
                if(onSecondCommand2()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_FirstCancel:
                if(onFirstCancel()) {
                    ev.consume();
                    return;
                }
                break;

        }
        if(ev.getComponent() != null) {
            handleComponentAction(ev.getComponent(), ev);
        }
    }

    protected void exitForm(Form f) {
        if("Second".equals(f.getName())) {
            exitSecond(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("First".equals(f.getName())) {
            exitFirst(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void exitSecond(Form f) {
    }


    protected void exitFirst(Form f) {
    }

    protected void beforeShow(Form f) {
    aboutToShowThisContainer = f;
        if("Second".equals(f.getName())) {
            beforeSecond(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("First".equals(f.getName())) {
            beforeFirst(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeSecond(Form f) {
    }


    protected void beforeFirst(Form f) {
    }

    protected void beforeShowContainer(Container c) {
        aboutToShowThisContainer = c;
        if("Second".equals(c.getName())) {
            beforeContainerSecond(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("First".equals(c.getName())) {
            beforeContainerFirst(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeContainerSecond(Container c) {
    }


    protected void beforeContainerFirst(Container c) {
    }

    protected void postShow(Form f) {
        if("Second".equals(f.getName())) {
            postSecond(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("First".equals(f.getName())) {
            postFirst(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postSecond(Form f) {
    }


    protected void postFirst(Form f) {
    }

    protected void postShowContainer(Container c) {
        if("Second".equals(c.getName())) {
            postContainerSecond(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("First".equals(c.getName())) {
            postContainerFirst(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postContainerSecond(Container c) {
    }


    protected void postContainerFirst(Container c) {
    }

    protected void onCreateRoot(String rootName) {
        if("Second".equals(rootName)) {
            onCreateSecond();
            aboutToShowThisContainer = null;
            return;
        }

        if("First".equals(rootName)) {
            onCreateFirst();
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void onCreateSecond() {
    }


    protected void onCreateFirst() {
    }

    protected Hashtable getFormState(Form f) {
        Hashtable h = super.getFormState(f);
        if("Second".equals(f.getName())) {
            getStateSecond(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("First".equals(f.getName())) {
            getStateFirst(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

            return h;
    }


    protected void getStateSecond(Form f, Hashtable h) {
    }


    protected void getStateFirst(Form f, Hashtable h) {
    }

    protected void setFormState(Form f, Hashtable state) {
        super.setFormState(f, state);
        if("Second".equals(f.getName())) {
            setStateSecond(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("First".equals(f.getName())) {
            setStateFirst(f, state);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void setStateSecond(Form f, Hashtable state) {
    }


    protected void setStateFirst(Form f, Hashtable state) {
    }

    protected void handleComponentAction(Component c, ActionEvent event) {
        Container rootContainerAncestor = getRootAncestor(c);
        if(rootContainerAncestor == null) return;
        String rootContainerName = rootContainerAncestor.getName();
        Container leadParentContainer = c.getParent().getLeadParent();
        if(leadParentContainer != null && leadParentContainer.getClass() != Container.class) {
            c = c.getParent().getLeadParent();
        }
        if(rootContainerName == null) return;
        if(rootContainerName.equals("Second")) {
            if("Button".equals(c.getName())) {
                onSecond_ButtonAction(c, event);
                return;
            }
            if("Button1".equals(c.getName())) {
                onSecond_Button1Action(c, event);
                return;
            }
            if("Button2".equals(c.getName())) {
                onSecond_Button2Action(c, event);
                return;
            }
            if("Button3".equals(c.getName())) {
                onSecond_Button3Action(c, event);
                return;
            }
            if("Button4".equals(c.getName())) {
                onSecond_Button4Action(c, event);
                return;
            }
            if("Button5".equals(c.getName())) {
                onSecond_Button5Action(c, event);
                return;
            }
            if("Button6".equals(c.getName())) {
                onSecond_Button6Action(c, event);
                return;
            }
            if("Button7".equals(c.getName())) {
                onSecond_Button7Action(c, event);
                return;
            }
            if("Button8".equals(c.getName())) {
                onSecond_Button8Action(c, event);
                return;
            }
        }
        if(rootContainerName.equals("First")) {
            if("Button".equals(c.getName())) {
                onFirst_ButtonAction(c, event);
                return;
            }
            if("Button1".equals(c.getName())) {
                onFirst_Button1Action(c, event);
                return;
            }
            if("RadioButton".equals(c.getName())) {
                onFirst_RadioButtonAction(c, event);
                return;
            }
            if("RadioButton1".equals(c.getName())) {
                onFirst_RadioButton1Action(c, event);
                return;
            }
            if("RadioButton2".equals(c.getName())) {
                onFirst_RadioButton2Action(c, event);
                return;
            }
            if("RadioButton3".equals(c.getName())) {
                onFirst_RadioButton3Action(c, event);
                return;
            }
        }
    }

      protected void onSecond_ButtonAction(Component c, ActionEvent event) {
      }

      protected void onSecond_Button1Action(Component c, ActionEvent event) {
      }

      protected void onSecond_Button2Action(Component c, ActionEvent event) {
      }

      protected void onSecond_Button3Action(Component c, ActionEvent event) {
      }

      protected void onSecond_Button4Action(Component c, ActionEvent event) {
      }

      protected void onSecond_Button5Action(Component c, ActionEvent event) {
      }

      protected void onSecond_Button6Action(Component c, ActionEvent event) {
      }

      protected void onSecond_Button7Action(Component c, ActionEvent event) {
      }

      protected void onSecond_Button8Action(Component c, ActionEvent event) {
      }

      protected void onFirst_ButtonAction(Component c, ActionEvent event) {
      }

      protected void onFirst_Button1Action(Component c, ActionEvent event) {
      }

      protected void onFirst_RadioButtonAction(Component c, ActionEvent event) {
      }

      protected void onFirst_RadioButton1Action(Component c, ActionEvent event) {
      }

      protected void onFirst_RadioButton2Action(Component c, ActionEvent event) {
      }

      protected void onFirst_RadioButton3Action(Component c, ActionEvent event) {
      }

}
