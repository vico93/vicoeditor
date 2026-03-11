package com.vicoeditor.editor.assets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AssetDimensionValidatorTest {

    @Test
    void acceptsValidTileset() {
        AssetValidationResult result = AssetDimensionValidator.validate(AssetCategory.TILESET, 256, 512);
        assertTrue(result.isValid());
    }

    @Test
    void rejectsInvalidTilesetWidth() {
        AssetValidationResult result = AssetDimensionValidator.validate(AssetCategory.TILESET, 320, 512);
        assertFalse(result.isValid());
    }

    @Test
    void acceptsAnimatedAutotileSheet() {
        AssetValidationResult result = AssetDimensionValidator.validate(AssetCategory.AUTOTILE, 96 * 3, 128);
        assertTrue(result.isValid());
    }

    @Test
    void rejectsAutotileWrongHeight() {
        AssetValidationResult result = AssetDimensionValidator.validate(AssetCategory.AUTOTILE, 96, 96);
        assertFalse(result.isValid());
    }

    @Test
    void acceptsCharacterSheetDivisibleByFour() {
        AssetValidationResult result = AssetDimensionValidator.validate(AssetCategory.CHARACTER, 128, 192);
        assertTrue(result.isValid());
    }

    @Test
    void rejectsCharacterSheetNotDivisibleByFour() {
        AssetValidationResult result = AssetDimensionValidator.validate(AssetCategory.CHARACTER, 130, 192);
        assertFalse(result.isValid());
    }

    @Test
    void warnsForVeryLargeFlexibleAssetsButKeepsValid() {
        AssetValidationResult result = AssetDimensionValidator.validate(AssetCategory.PANORAMA, 8192, 4096);
        assertTrue(result.isValid());
        assertFalse(result.issues().isEmpty());
    }
}
