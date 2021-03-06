package property.pattern;

import log.Log;
import log.Snapshot;
import property.Property;
import property.PropertyChecker;

import java.util.HashMap;

public abstract class NumberofEventsChecker extends PropertyChecker {
    @Override
    protected abstract boolean evaluateState(Snapshot snapshot, Property verificationProperty);

    @Override
    public boolean check(Log log, Property verificationProperty) {
        HashMap<Integer, Snapshot> snapshots = log.getSnapshotMap();
        int logSize = snapshots.size(); // 0 ... 10 => size: 11, endTime: 10

        for (int i = logSize; i <= logSize; i++) {
            if (evaluateState(snapshots.get(i), verificationProperty)) {
                return false;
            }
        }
        return true;
    }


//    @Override
//    public boolean check(Log log, Property verificationProperty) {
//        if (evaluateState(log, verificationProperty)) return true;
//        else return false;
//    }
}
