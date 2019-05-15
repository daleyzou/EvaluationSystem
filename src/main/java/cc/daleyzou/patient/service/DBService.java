package cc.daleyzou.patient.service;

import cc.daleyzou.patient.domain.*;
import cc.daleyzou.patient.server.DicomReader;


public interface DBService {

    void buildEntities(DicomReader reader);

    Patient buildPatient(DicomReader reader);

    Study buildStudy(DicomReader reader, Patient patient);

    Series buildSeries(DicomReader reader, Study study);

    Equipment buildEquipment(DicomReader reader, Series series);

    Instance buildInstance(DicomReader reader, Series series);
}
