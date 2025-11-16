package rsc.Utility;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import static rsc.Utility.UtilApi.UTL;

public class OffsetDateTimeDeserializer extends JsonDeserializer<OffsetDateTime> {

    @Override
    public OffsetDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JacksonException {

        String date = jsonParser.getText();
        try {
            return OffsetDateTime.parse(date, DateTimeFormatter.ISO_OFFSET_DATE_TIME);

        } catch (Exception e1) {
            try {
                return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd' 'HH:mm:ss"))
                        .atOffset(OffsetDateTime.now().getOffset());

            } catch (Exception e2) {
                try {
                    LocalTime time = LocalTime.parse(date, DateTimeFormatter.ofPattern("HH:mm:ss"));
                    return LocalDateTime.now().with(time).atOffset(OffsetDateTime.now().getOffset());

                } catch (Exception e3) {
                    try {
                        // Nuevo: intenta parsear solo fecha
                        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        return localDate.atStartOfDay().atOffset(OffsetDateTime.now().getOffset());

                    } catch (Exception e4) {
                        UTL.logService().logError("deserializer", e4);
                        return null;
                    }
                }
            }
        }
    }
}
