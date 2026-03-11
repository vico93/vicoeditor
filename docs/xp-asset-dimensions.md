# XP-Style Asset Dimensions

This project targets a Love2D runtime, but keeps RPG Maker XP-like asset dimensions and layout conventions.

## Tile and Map Basics

- Base tile size: `32x32`.
- Tileset grid: `8` columns fixed.

## Required Dimensions (Strict)

- `tileset`: width `256` (8 * 32), height multiple of `32`.
- `autotile`: width multiple of `96` (animated frames side by side), height `128`.
- `icon`: `24x24`.
- `title`: `640x480`.
- `gameover`: `640x480`.
- `battleback`: `640x320`.
- `windowskin`: `192x128`.
- `animation`: width `960` (5 * 192), height multiple of `192`.
- `transition`: `640x480`.

## Structural Rules (Strict)

- `character` sheets must be divisible in a `4x4` grid.
  - Width must be divisible by `4`.
  - Height must be divisible by `4`.

## Flexible Dimensions

- `panorama`: no fixed size.
- `fog`: no fixed size.
- `picture`: no fixed size.

The editor may emit warnings for very large images in these flexible groups, but it does not reject them by default.
