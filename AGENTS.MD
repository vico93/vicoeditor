# AGENTS

This repository uses `vibe_check` as the primary course-correction tool.

## Vibe-Check Workflow

- Always include the full user prompt when calling `vibe_check`.
- Treat `vibe_check` as a pattern interrupt, not an optional extra.
- Use `vibe_check` at these points:
  - after planning and before implementation
  - when complexity increases
  - before significant system changes
- Always include the current phase in the call context: `planning`, `implementation`, or `review`.
- Adapt the approach based on `vibe_check` feedback unless it is clearly irrelevant.
- Chain `vibe_check` with execution naturally; do not stop to ask permission.
- After resolving a recurring issue or confirming a useful pattern, record it with `vibe_learn`.

## Repo Direction

- The Lazarus prototype has been retired.
- The active editor code lives under `editor/`.
- Generated game/runtime template assets should live outside the editor module, such as `runtime-template/`.
