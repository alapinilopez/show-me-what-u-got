// package edu.poniperro;

// import static io.restassured.RestAssured.given;
// import static org.hamcrest.CoreMatchers.is;
// import static org.hamcrest.Matchers.equalTo;

// import java.util.List;
// import java.util.Map;

// import javax.inject.Inject;
// import javax.persistence.EntityManager;
// import javax.persistence.TypedQuery;
// import javax.transaction.Transactional;
// import javax.ws.rs.core.MediaType;

// import org.assertj.core.api.Assertions;
// import org.junit.jupiter.api.Test;

// import io.quarkus.test.junit.QuarkusTest;
// import io.restassured.common.mapper.TypeRef;
// import io.restassured.http.ContentType;



// @QuarkusTest
// public class ResourcesTest {

//     @Inject
//     EntityManager em;

//     @Inject
//     ResourcesOlli resources;
//     /**
// 	 * Implementa una clase Resources que
// 	 * añada una API REST a nuestra app.
// 	 * Injecta el servicio en Resources.
//      */

//     @Test
//     public void test_injeccion() {
//         Assertions.assertThat(resources.service).isNotNull();
//     }

//     /**
//      * En el endpoint /wellcome
//      * recibimos un TEXT con el mensaje
//      * "Wellcome Ollivanders!""
//      */

//     @Test
//     public void test_wellcome() {
//         given()
//             .contentType(ContentType.TEXT)
//         .when()
//             .get("/wellcome")
//         .then()
//             .statusCode(200)
//             .body(is("Wellcome Ollivanders!"));
//     }
// }

