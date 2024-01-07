package cm1007.patientservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    void testGetAllPatients() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/patient/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].patientId").exists())
                .andExpect(jsonPath("$[0].patientName").exists());
    }

    @Test
    @WithMockUser
    void testGetPatient() throws Exception {
        String patientId = "-1";

        mockMvc.perform(MockMvcRequestBuilders.get("/patient/{patientId}", patientId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.patientId").exists())
                .andExpect(jsonPath("$.patientName").exists())
                .andExpect(jsonPath("$.encounters").isArray())
                .andExpect(jsonPath("$.conditions").isArray())
                .andExpect(jsonPath("$.notes").isArray());
    }

    @Test
    @WithMockUser
    void testGetAllEncounter() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/patient/encounter/list"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").exists())
                .andExpect(jsonPath("$[0].patientId").exists())
                .andExpect(jsonPath("$[0].encounterDate").exists());
    }

    /*
    @Test
    @WithMockUser
    void testAddNote() throws Exception {
        String patientId = "patientId";
        CreateNoteVM note = new CreateNoteVM();
        note.setNote("Test note");

        mockMvc.perform(MockMvcRequestBuilders.post("/patient/addNote/{patientId}", patientId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(note)))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void testCreatePatient() throws Exception {
        PatientCreateVM patientCreateVM = new PatientCreateVM();
        patientCreateVM.setId("testId");
        patientCreateVM.setFullName("Test Patient");

        mockMvc.perform(MockMvcRequestBuilders.post("/patient/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(patientCreateVM)))
                .andExpect(status().isCreated());
    }

    @Test
    @WithMockUser
    void testAddCondition() throws Exception {
        ConditionCreateVM conditionCreateVM = new ConditionCreateVM();
        conditionCreateVM.setPatientId("patientId");
        conditionCreateVM.setConditionType("Test Condition");

        mockMvc.perform(MockMvcRequestBuilders.post("/patient/condition/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(conditionCreateVM)))
                .andExpect(status().isCreated());
    }
     */

    /*
    @Test
    @WithMockUser
    void testAddEncounter() throws Exception {
        EncounterCreateVM encounterCreateVM = new EncounterCreateVM();
        encounterCreateVM.setPatientId("patientId");
        encounterCreateVM.setDoctorId("doctorId");

        mockMvc.perform(MockMvcRequestBuilders.post("/patient/encounter/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(encounterCreateVM)))
                .andExpect(status().isCreated());
    }

    @Test
    @WithMockUser
    void testAddObservation() throws Exception {
        ObservationCreateVM observationCreateVM = new ObservationCreateVM();
        observationCreateVM.setEncounterId(1L);
        observationCreateVM.setObservationDetails("Test Observation");

        mockMvc.perform(MockMvcRequestBuilders.post("/patient/observation/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(observationCreateVM)))
                .andExpect(status().isCreated());
    }
     */
}

