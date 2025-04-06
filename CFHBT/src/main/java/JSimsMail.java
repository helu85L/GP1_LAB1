

    
<?xml version="1.0" encoding="UTF-8" ?>

<Form version="1.3" maxVersion="1.9" type="org.netbeans.modules.form.forminfo.JFrameFormInfo">
  <NonVisualComponents>
    <Menu class="javax.swing.JMenuBar" name="menuBar">
      <SubComponents>
        <Menu class="javax.swing.JMenu" name="fileMenu">
          <Properties>
            <Property name="mnemonic" type="int" value="102"/>
            <Property name="text" type="java.lang.String" value="File"/>
          </Properties>
          <SubComponents>
            <MenuItem class="javax.swing.JMenuItem" name="exitMenuItem">
              <Properties>
                <Property name="mnemonic" type="int" value="120"/>
                <Property name="text" type="java.lang.String" value="Exit"/>
              </Properties>
              <Events>
                <EventHandler event="actionPerformed" listener="java.awt.event.ActionListener" parameters="java.awt.event.ActionEvent" handler="exitMenuItemActionPerformed"/>
              </Events>
            </MenuItem>
          </SubComponents>
        </Menu>
        <Menu class="javax.swing.JMenu" name="mnuOrganization">
          <Properties>
            <Property name="mnemonic" type="int" value="79"/>
            <Property name="text" type="java.lang.String" value="Institution"/>
          </Properties>
          <SubComponents>
            <MenuItem class="javax.swing.JMenuItem" name="mnuiNewCollege">
              <Properties>
                <Property name="accelerator" type="javax.swing.KeyStroke" editor="org.netbeans.modules.form.editors.KeyStrokeEditor">
                  <KeyStroke key="Ctrl+C"/>
                </Property>
                <Property name="text" type="java.lang.String" value="New College"/>
              </Properties>
              <Events>
                <EventHandler event="actionPerformed" listener="java.awt.event.ActionListener" parameters="java.awt.event.ActionEvent" handler="mnuiNewCollegeActionPerformed"/>
              </Events>
            </MenuItem>
            <MenuItem class="javax.swing.JMenuItem" name="mnuiNewDepartment">
              <Properties>
                <Property name="accelerator" type="javax.swing.KeyStroke" editor="org.netbeans.modules.form.editors.KeyStrokeEditor">
                  <KeyStroke key="Ctrl+D"/>
                </Property>
                <Property name="text" type="java.lang.String" value="New Department"/>
              </Properties>
              <Events>
                <EventHandler event="actionPerformed" listener="java.awt.event.ActionListener" parameters="java.awt.event.ActionEvent" handler="mnuiNewDepartmentActionPerformed"/>
              </Events>
            </MenuItem>
            <MenuItem class="javax.swing.JMenuItem" name="mnuiViewColleges">
              <Properties>
                <Property name="text" type="java.lang.String" value="View Colleges"/>
              </Properties>
              <Events>
                <EventHandler event="actionPerformed" listener="java.awt.event.ActionListener" parameters="java.awt.event.ActionEvent" handler="mnuiViewCollegesActionPerformed"/>
              </Events>
            </MenuItem>
          </SubComponents>
        </Menu>
        <Menu class="javax.swing.JMenu" name="helpMenu">
          <Properties>
            <Property name="mnemonic" type="int" value="104"/>
            <Property name="text" type="java.lang.String" value="Help"/>
          </Properties>
          <SubComponents>
            <MenuItem class="javax.swing.JMenuItem" name="contentMenuItem">
              <Properties>
                <Property name="mnemonic" type="int" value="99"/>
                <Property name="text" type="java.lang.String" value="Contents"/>
              </Properties>
            </MenuItem>
            <MenuItem class="javax.swing.JMenuItem" name="aboutMenuItem">
              <Properties>
                <Property name="mnemonic" type="int" value="97"/>
                <Property name="text" type="java.lang.String" value="About"/>
              </Properties>
            </MenuItem>
          </SubComponents>
        </Menu>
      </SubComponents>
    </Menu>
  </NonVisualComponents>
  <Properties>
    <Property name="defaultCloseOperation" type="int" value="3"/>
    <Property name="title" type="java.lang.String" value="JSims - Student Information Management System"/>
  </Properties>
  <SyntheticProperties>
    <SyntheticProperty name="menuBar" type="java.lang.String" value="menuBar"/>
    <SyntheticProperty name="formSizePolicy" type="int" value="1"/>
    <SyntheticProperty name="generateCenter" type="boolean" value="true"/>
  </SyntheticProperties>
  <AuxValues>
    <AuxValue name="FormSettings_autoResourcing" type="java.lang.Integer" value="0"/>
    <AuxValue name="FormSettings_autoSetComponentName" type="java.lang.Boolean" value="false"/>
    <AuxValue name="FormSettings_generateFQN" type="java.lang.Boolean" value="true"/>
    <AuxValue name="FormSettings_generateMnemonicsCode" type="java.lang.Boolean" value="false"/>
    <AuxValue name="FormSettings_i18nAutoMode" type="java.lang.Boolean" value="false"/>
    <AuxValue name="FormSettings_layoutCodeTarget" type="java.lang.Integer" value="1"/>
    <AuxValue name="FormSettings_listenerGenerationStyle" type="java.lang.Integer" value="0"/>
    <AuxValue name="FormSettings_variablesLocal" type="java.lang.Boolean" value="false"/>
    <AuxValue name="FormSettings_variablesModifier" type="java.lang.Integer" value="2"/>
  </AuxValues>

  <Layout>
    <DimensionLayout dim="0">
      <Group type="103" groupAlignment="0" attributes="0">
          <Component id="desktopPane" pref="783" max="32767" attributes="0"/>
      </Group>
    </DimensionLayout>
    <DimensionLayout dim="1">
      <Group type="103" groupAlignment="0" attributes="0">
          <Component id="desktopPane" pref="517" max="32767" attributes="0"/>
      </Group>
    </DimensionLayout>
  </Layout>
  <SubComponents>
    <Container class="javax.swing.JDesktopPane" name="desktopPane">

      <Layout class="org.netbeans.modules.form.compat2.layouts.DesignAbsoluteLayout">
        <Property name="useNullLayout" type="boolean" value="true"/>
      </Layout>
    </Container>
  </SubComponents>
</Form>

  
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JSimsMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JSimsMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JSimsMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JSimsMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

