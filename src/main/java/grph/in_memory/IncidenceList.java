package grph.in_memory;

import grph.properties.ObjectProperty;
import toools.NotYetImplementedException;
import toools.set.IntSet;

public class IncidenceList implements Cloneable {
	protected final IncidenceListProperty p;

	public IncidenceList() {
		p = new IncidenceListProperty();
	}

	protected IncidenceList(IncidenceListProperty p) {
		this.p = p;
	}

	public IntSet getValue(int e) {
		return p.getValue(e);
	}

	public void remove(int a, int b) {
		p.getValue(a).remove(b);
	}

	public boolean hasValue(int e) {

		return p.getValue(e) != null;
	}

	public void add(int a, int b) {
		p.getValue(a).add(b);
	}

	public void setEmptySet(int e) {
		p.setValue(e, new GrphInternalSet());
	}

	public void unsetValue(int e) {
		p.setValue(e, (GrphInternalSet) null);
		p.setStatus(e, false);
	}

	@Override
	protected Object clone() {
		return new IncidenceList((IncidenceListProperty) p.clone());
	}

	protected static class IncidenceListProperty extends ObjectProperty<GrphInternalSet> implements Cloneable {

		public IncidenceListProperty() {
			super(null);
		}

		@Override
		public boolean acceptValue(GrphInternalSet value) {
			return true;
		}

		@Override
		protected long sizeOf(GrphInternalSet o) {
			throw new NotYetImplementedException();
		}

		@Override
		public void setValue(int e, String value) {
			throw new NotYetImplementedException();
		}

		@Override
		protected Object clone() {
			IncidenceListProperty clone = new IncidenceListProperty();
			this.cloneValuesTo(clone);
			return clone;
		}

	}
}
