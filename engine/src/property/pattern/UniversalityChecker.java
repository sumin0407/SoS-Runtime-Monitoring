package property.pattern;

import log.Log;
import log.Snapshot;
import property.Property;
import property.PropertyChecker;

import java.util.HashMap;

/**
 * The type Universality checker.
 * checks whether a property is satisfied for all logs
 */
public abstract class UniversalityChecker extends PropertyChecker {
    @Override
    protected abstract boolean evaluateState(Snapshot state, Property verificationProperty);

    @Override
    public boolean check(Log log, Property verificationProperty) {
        HashMap<Integer, Snapshot> snapshots = log.getSnapshotMap();
        int logSize = snapshots.size(); // 0 ... 10 => size: 11, endTime: 10

        for (int i = logSize; i <= logSize; i++) {
            if (!evaluateState(snapshots.get(i), verificationProperty)) {
                return false;
            }
        }
        return true;
    }
}
