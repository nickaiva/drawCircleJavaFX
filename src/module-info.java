module drawCircleJavaFX {
	
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires java.logging;
	
	exports drawCircleJavaFX;
	opens drawCircleJavaFX to javafx.fxml;	
}