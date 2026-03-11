package com.vicoeditor.editor.assets;

public final class AssetDimensionValidator {
    private static final int TILE_SIZE = 32;
    private static final int TILESET_WIDTH = 8 * TILE_SIZE;

    private AssetDimensionValidator() {
    }

    public static AssetValidationResult validate(AssetCategory category, int width, int height) {
        AssetValidationResult result = new AssetValidationResult();

        if (width <= 0 || height <= 0) {
            result.addError("Image dimensions must be greater than zero.");
            return result;
        }

        switch (category) {
            case TILESET -> validateTileset(width, height, result);
            case AUTOTILE -> validateAutotile(width, height, result);
            case ICON -> validateExact(width, height, 24, 24, "Icon", result);
            case TITLE -> validateExact(width, height, 640, 480, "Title", result);
            case GAMEOVER -> validateExact(width, height, 640, 480, "Game Over", result);
            case BATTLEBACK -> validateExact(width, height, 640, 320, "Battleback", result);
            case WINDOWSKIN -> validateExact(width, height, 192, 128, "Windowskin", result);
            case ANIMATION -> validateAnimation(width, height, result);
            case TRANSITION -> validateExact(width, height, 640, 480, "Transition", result);
            case CHARACTER -> validateCharacter(width, height, result);
            case PANORAMA, FOG, PICTURE -> validateFlexible(width, height, result);
        }

        return result;
    }

    private static void validateTileset(int width, int height, AssetValidationResult result) {
        if (width != TILESET_WIDTH) {
            result.addError("Tileset width must be exactly 256 (8 tiles x 32px).");
        }
        if (height % TILE_SIZE != 0) {
            result.addError("Tileset height must be a multiple of 32.");
        }
    }

    private static void validateAutotile(int width, int height, AssetValidationResult result) {
        if (height != 128) {
            result.addError("Autotile height must be exactly 128 (4 tiles x 32px).");
        }
        if (width % 96 != 0) {
            result.addError("Autotile width must be a multiple of 96 (3 tiles x 32px per frame).");
        }
    }

    private static void validateAnimation(int width, int height, AssetValidationResult result) {
        if (width != 960) {
            result.addError("Animation sheet width must be exactly 960 (5 frames x 192px).");
        }
        if (height % 192 != 0) {
            result.addError("Animation sheet height must be a multiple of 192.");
        }
    }

    private static void validateCharacter(int width, int height, AssetValidationResult result) {
        if (width % 4 != 0) {
            result.addError("Character sheet width must be divisible by 4.");
        }
        if (height % 4 != 0) {
            result.addError("Character sheet height must be divisible by 4.");
        }
    }

    private static void validateFlexible(int width, int height, AssetValidationResult result) {
        if (width > 4096 || height > 4096) {
            result.addWarning("Very large image detected (> 4096px). This may affect editor/runtime performance.");
        }
    }

    private static void validateExact(
            int width,
            int height,
            int expectedWidth,
            int expectedHeight,
            String name,
            AssetValidationResult result
    ) {
        if (width != expectedWidth || height != expectedHeight) {
            result.addError(name + " must be exactly " + expectedWidth + "x" + expectedHeight + ".");
        }
    }
}
