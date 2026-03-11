module com.vicoeditor.editor {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.vicoeditor.editor to javafx.fxml;
    exports com.vicoeditor.editor;
    exports com.vicoeditor.editor.assets;
}
