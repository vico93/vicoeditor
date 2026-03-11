package com.vicoeditor.editor.assets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AssetValidationResult {
    private final List<AssetValidationIssue> issues = new ArrayList<>();

    public void addError(String message) {
        issues.add(new AssetValidationIssue(AssetValidationSeverity.ERROR, message));
    }

    public void addWarning(String message) {
        issues.add(new AssetValidationIssue(AssetValidationSeverity.WARNING, message));
    }

    public boolean isValid() {
        return issues.stream().noneMatch(issue -> issue.severity() == AssetValidationSeverity.ERROR);
    }

    public List<AssetValidationIssue> issues() {
        return Collections.unmodifiableList(issues);
    }
}
