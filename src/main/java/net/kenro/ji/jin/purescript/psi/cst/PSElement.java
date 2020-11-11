package net.kenro.ji.jin.purescript.psi.cst;

import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.CompositePsiElement;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PSElement extends CompositePsiElement {
    protected PSElement(@NotNull IElementType type) {
        super(type);
    }

    @SuppressWarnings("unchecked")
    @NotNull
    public <T extends PSElement> T[] findChildren(Class<T> type) {
        ArrayList<T> result = new ArrayList<T>();
        for (PsiElement psiElement : this.getChildren()) {
            if (type.isInstance(psiElement)) {
                result.add((T) psiElement);
            }
        }

        return result.toArray((T[]) Array.newInstance(type, result.size()));
    }
}
