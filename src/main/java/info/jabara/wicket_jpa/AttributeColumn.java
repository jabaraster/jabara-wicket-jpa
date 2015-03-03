package info.jabara.wicket_jpa;

import jabara.bean.BeanProperties;
import jabara.general.ArgUtil;
import jabara.wicket.Models;

import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.SingularAttribute;

import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.model.IModel;

/**
 * @param <E> 行の値となるオブジェクトの型.
 * @author jabaraster
 */
public class AttributeColumn<E> extends PropertyColumn<E, String> {
    private static final long serialVersionUID = -8311427284072422312L;

    /**
     * @param pMeta -
     * @param pAttribute -
     */
    public AttributeColumn(final BeanProperties pMeta, final Attribute<?, ? extends Comparable<?>> pAttribute) {
        this(Models.readOnly(pMeta.get(pAttribute.getName()).getLocalizedName()), pAttribute);
    }

    /**
     * @param pLabel -
     * @param pAttribute -
     */
    public AttributeColumn(final IModel<String> pLabel, final Attribute<?, ? extends Comparable<?>> pAttribute) {
        super(pLabel, pAttribute.getName(), pAttribute.getName());
    }

    private AttributeColumn(final BeanProperties pMeta, final Attribute<?, ?> pAttribute //
            , @SuppressWarnings("unused") final Object pDummy) {
        this(Models.readOnly(pMeta.get(pAttribute.getName()).getLocalizedName()) //
                , pAttribute //
                , null);
    }

    private AttributeColumn(final IModel<String> pLabel, final Attribute<?, ?> pAttribute //
            , @SuppressWarnings("unused") final Object pDummy) {
        super(pLabel, pAttribute.getName());
    }

    /**
     * @param <V> -
     * @param pMeta -
     * @param pAttribute -
     * @return -
     */
    public static <V> AttributeColumn<V> sortable(final BeanProperties pMeta, final SingularAttribute<?, ? extends Comparable<?>> pAttribute) {
        ArgUtil.checkNull(pMeta, "pMeta"); //$NON-NLS-1$
        ArgUtil.checkNull(pAttribute, "pAttribute"); //$NON-NLS-1$
        return new AttributeColumn<V>(pMeta, pAttribute);
    }

    /**
     * @param pLabel -
     * @param pAttribute -
     * @return -
     */
    public static <V> AttributeColumn<V> sortable(final IModel<String> pLabel, final SingularAttribute<?, ? extends Comparable<?>> pAttribute) {
        ArgUtil.checkNull(pLabel, "pLabel"); //$NON-NLS-1$
        ArgUtil.checkNull(pAttribute, "pAttribute"); //$NON-NLS-1$
        return new AttributeColumn<V>(pLabel, pAttribute, null);
    }

    /**
     * @param pLabel -
     * @param pAttribute -
     * @return -
     */
    public static <V> AttributeColumn<V> sortable(final String pLabel, final SingularAttribute<?, ? extends Comparable<?>> pAttribute) {
        ArgUtil.checkNull(pAttribute, "pAttribute"); //$NON-NLS-1$
        return new AttributeColumn<V>(Models.readOnly(pLabel), pAttribute);
    }

    /**
     * @param <V> -
     * @param pMeta -
     * @param pAttribute -
     * @return -
     */
    public static <V> AttributeColumn<V> unsortable(final BeanProperties pMeta, final Attribute<?, ?> pAttribute) {
        ArgUtil.checkNull(pMeta, "pMeta"); //$NON-NLS-1$
        ArgUtil.checkNull(pAttribute, "pAttribute"); //$NON-NLS-1$
        return new AttributeColumn<V>(pMeta, pAttribute, null);
    }

    /**
     * @param pLabel -
     * @param pAttribute -
     * @return -
     */
    public static <V> AttributeColumn<V> unsortable(final IModel<String> pLabel, final Attribute<?, ?> pAttribute) {
        ArgUtil.checkNull(pLabel, "pLabel"); //$NON-NLS-1$
        ArgUtil.checkNull(pAttribute, "pAttribute"); //$NON-NLS-1$
        return new AttributeColumn<V>(pLabel, pAttribute, null);
    }

    /**
     * @param pLabel -
     * @param pAttribute -
     * @return -
     */
    public static <V> AttributeColumn<V> unsortable(final String pLabel, final Attribute<?, ?> pAttribute) {
        ArgUtil.checkNull(pAttribute, "pAttribute"); //$NON-NLS-1$
        return new AttributeColumn<V>(Models.readOnly(pLabel), pAttribute, null);
    }
}