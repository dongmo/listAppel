package listeAppel;

import java.util.List;

public class Planning {

	private List<Programme> programmes;

	/**
	 * @return the programmes
	 */
	public List<Programme> getProgrammes() {
		return programmes;
	}

	/**
	 * @param programmes the programmes to set
	 */
	public void setProgrammes(List<Programme> programmes) {
		this.programmes = programmes;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Planning [programmes=" + programmes + "]";
	}
}
