package cc.daleyzou;

import cc.daleyzou.common.config.FebsProperties;
import cc.daleyzou.patient.component.ActiveDicoms;
import cc.daleyzou.patient.handler.IncomingFileHandler;
import cc.daleyzou.patient.server.DicomServer;
import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import org.opencv.core.Core;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("cc.daleyzou.*.dao")
@EnableConfigurationProperties({FebsProperties.class})
@EnableCaching
@EnableAsync
public class Application {

    private static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        SpringApplication.run(Application.class, args);
        log.info("《《《《《《 MRI System started up successfully at {} {} 》》》》》》", LocalDate.now(), LocalTime.now());
    }



    /************************** Handler for incoming files works with asynchronous event bus initiated by the DicomServer ****************************/
    @Bean // only one incoming file handler. Even we have multiple DicomServer instances, they all forward files to the same handler...
    public IncomingFileHandler incomingFileHandler() {
        return new IncomingFileHandler();
    }

    @Bean //Guava asynch event bus that initiates 100 fixed thread pool
    public EventBus asyncEventBus() {
        EventBus eventBus = new AsyncEventBus(java.util.concurrent.Executors.newFixedThreadPool(100));
        return eventBus;
    }

    @Bean //dicom server takes storage output directory, ae title and ports. Server listens same number of ports with same ae title
    public Map<String, DicomServer> dicomServers(@Value("${pacs.storage.dcm}") String storageDir, @Value("${pacs.aetitle}") String aeTitle,
            @Value("#{'${pacs.ports}'.split(',')}") List<Integer> ports) {

        Map<String, DicomServer> dicomServers = new HashMap<>();
        for (int port : ports) {
            dicomServers.put("DICOM_SERVER_AT_" + port, DicomServer.init(null, port, aeTitle, storageDir, asyncEventBus()));
        }
        return dicomServers;
    }

    /************************** End of Handler for incoming files works with asynchronous event bus initiated by the DicomServer ****************************/

    @Bean
    @Qualifier(value = "activeDicoms")
    public ActiveDicoms activeDicoms() {
        return new ActiveDicoms();
    }
}
