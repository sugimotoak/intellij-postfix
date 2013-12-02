package org.jetbrains.postfixCompletion.templates;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiExpression;
import com.intellij.psi.PsiStatement;
import com.intellij.psi.PsiType;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

abstract public class BooleanPostfixTemplate2 extends PostfixTemplate {
  protected BooleanPostfixTemplate2(@Nullable String name, @NotNull String key) {
    super(name, key);
  }

  @Nullable
  public PsiExpression getTopmostExpression(PsiElement context) {
    return PsiTreeUtil.getTopmostParentOfType(context, PsiExpression.class);
  }

  @Override
  public boolean isApplicable(@NotNull PsiElement context) {
    PsiExpression topmostExpression = getTopmostExpression(context);
    return topmostExpression != null &&
           topmostExpression.getParent() instanceof PsiStatement &&
           PsiType.BOOLEAN == topmostExpression.getType();
  }
}