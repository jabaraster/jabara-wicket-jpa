/**
 * 
 */
package info.jabara.wicket_jpa;

import jabara.bean.BeanProperties;

import javax.persistence.metamodel.Attribute;

import org.apache.wicket.model.IModel;

/**
 * @param <E> 行の値を保持するオブジェクトの型.
 * @author jabaraster
 */
public class DateTimeColumn<E> extends DateColumnBase<E> {
    private static final long  serialVersionUID = -9222794771582716966L;

    /**
     * 
     */
    public static final String FORMAT           = "yyyy/MM/dd HH:mm:ss"; //$NON-NLS-1$

    /**
     * @param pMeta -
     * @param pAttribute -
     */
    public DateTimeColumn(final BeanProperties pMeta, final Attribute<?, ? extends Comparable<?>> pAttribute) {
        super(pMeta, pAttribute, FORMAT);
    }

    /**
     * @param pLabel -
     * @param pAttribute -
     */
    public DateTimeColumn(final IModel<String> pLabel, final Attribute<?, ? extends Comparable<?>> pAttribute) {
        super(pLabel, pAttribute, FORMAT);
    }

}
