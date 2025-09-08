# Saheel (صَهيل) -  Management Platform


Saheel is a digital platform designed to bring together all equestrian enthusiasts in one place. It connects three main user groups:

-Stable Owners: They can easily showcase their services such as horse boarding, training, and veterinary care. Each stable is managed by the owner and includes a full team of staff like trainers, veterinarians, and caretakers—all operating under the stable’s management.

-Horse Owners: They can browse through available stables, compare them based on location, services, and pricing, and subscribe directly through the platform.

-Customers (الخيالة والهواة): The platform helps turn casual horse lovers into skilled riders by offering professional courses delivered by stable owners and their expert teams.

Saheel isn't just a management system—it’s a complete equestrian ecosystem built for everyone passionate about horses.
-  **Stable Management** (staff, facilities, services)  
-  **Horse Tracking** (ownership, health, memberships)  
-  **Course Scheduling** (enrollments, payments, reviews)  
-  **Multi-role Access** (admins, stable owners, horse owners, customers)  



  
##  Technologies & Tools

| Technology         | Purpose                                       |
|--------------------|-----------------------------------------------|
| `Java   `          | Main programming language                     |
| `Spring Boot`      | Backend framework                             |
| `Spring Web`       | Build RESTful APIs                            |
| `Spring Data JPA`  | Handle database operations                    |
| `Spring Security`  | Login, roles, and authorization               |
| `Spring Mail`      | Send email notifications                      |
| `Spring Validation`| Validate user input                           |
| `MySQL` / `PostgreSQL` | Relational databases                      |
| `Lombok`           | Write clean Java code with fewer lines        |
| `Twilio`           | Send WhatsApp & SMS messages                  |
| `iText`            | Generate and export PDF documents             |
| `Moyasar API`      | Process online payments securely              |
| `AWS`              | Cloud deployment                              |
| `JUnit`            | Unit testing framework                        |
| `Postman`          | Test API endpoints                            |
| `Figma`            | UI/UX design and wireframes                 |
| `Maven`            | Build and manage dependencies                 |


## Architecture Diagrams

 ### Class Diagram
 (https://github.com/user-attachments/files/22203101/Saheel.diagram-1.1.pdf)

 ###  Use Case Diagram
 (https://github.com/user-attachments/files/22203101/Saheel.diagram-1.1.pdf) 

###  Figma Design
 🔗  [link](https://www.figma.com/proto/vAsUysev9ftupCdJQ4dgtA/final-progct--%D8%B5%D9%87%D9%8A%D9%84-?page-id=0%3A1&node-id=1-4&p=f&viewport=516%2C220%2C0.31&t=aPlb9Qhfbu3Pncuq-1&scaling=contain&content-scaling=fixed&starting-point-node-id=1%3A4)  

---

### Admin Endpoints

| #  | Entity | Endpoint                                                | Creator |
|----|--------|---------------------------------------------------------|---------|
| 1  | Admin  | `GET /most-horses`                                      | Abrar   |
| 2  | Admin  | `POST /send-welcome-to-all-customer`                    | Abrar   |
| 3  | Admin  | `POST /send-welcome-to-all-horseOwner`                 | Abrar   |
| 4  | Admin  | `PUT /approve-stable-owner/{stableOwnerId}`            | Abrar   |
| 5  | Admin  | `POST /send-membership-welcome`                        | Abrar   |
| 6  | Admin  | `GET /get-unapproved-stable-owners`                    | Abrar   |
| 7  | Admin  | `GET /get-all-stable-owners`                           | Abrar   |
| 8  | Admin  | `GET /get-all-customers`                               | Abrar   |
| 9  | Admin  | `GET /get-all-horse-owner`                             | Abrar   |
| 10 | Admin  | `POST /send-expiring-membership-notifications`        | Abeer   |
| 11 | Admin  | `PUT /change-membership-status/{membershipId}`         | Ayman   |


### Breeder Endpoints

| #  | Entity  | Endpoint                                             | Creator |
|----|---------|------------------------------------------------------|---------|
| 13 | Breeder | `GET /get/{breeder_Id}`                              | Abeer   |
| 14 | Breeder | `GET /search-by-name/{fullName}`                     | Abeer       |
| 15 | Breeder | `POST /add/{stable_Id}`                              | Abeer   |
| 16 | Breeder | `PUT /update-breeder/{breeder_Id}/by-stable/{stable_Id}` | Abeer   |
| 17 | Breeder | `DELETE /delete/{breeder_Id}`                        | Abeer   |


### Course Endpoints

| #  | Entity | Endpoint                                               | Creator |
|----|--------|--------------------------------------------------------|---------|
| 17 | Course | `GET /get-stable-courses/{stableId}`                  | Ayman     |
| 18 | Course | `POST /add-course-by-stable-owner/{stableId}/{trainerId}` | Ayman   |
| 19 | Course | `PUT /cancel-course/{stableId}/{courseId}`            | Ayman      |
| 20 | Course | `GET /get-available-courses`                          | Ayman      |
| 21 | Course | `GET /get-top-rated-course`                           | Ayman       |
| 22 | Course | `GET /get-courses-by-trainer/{trainerId}`             | Ayman       |
| 23 | Course | `GET /get-courses-by-date`                            | Ayman      |

### Course Enrollment Endpoints

| #  | Entity           | Endpoint                                               | Creator |
|----|------------------|--------------------------------------------------------|---------|
| 25 | CourseEnrollment | `GET /get-course-enrollments/{courseId}`              | Ayman      |
| 26 | CourseEnrollment | `POST /enroll-to-course/{courseId}`                   | Ayman       |
| 27 | CourseEnrollment | `PUT /cancel-enrollment/{courseEnrollmentId}`         | Ayman       |
| 28 | CourseEnrollment | `GET /get-canceled-enrollments/{stableId}`            | Ayman      |

### Course Review Endpoints

| #  | Entity        | Endpoint                                               | Creator |
|----|---------------|--------------------------------------------------------|---------|
| 29 | CourseReview  | `GET /get-course-reviews/{courseId}`                  | Ayman      |
| 30 | CourseReview  | `POST /review-course-by-customer/{courseId}`          | Ayman       |


### Customer Endpoints

| #  | Entity   | Endpoint                                  | Creator |
|----|----------|-------------------------------------------|---------|
| 31 | Customer | `POST /register-customer`                 | Ayman      |
| 32 | Customer | `GET /get-invoice-as-pdf/{invoiceId}`     | Ayman      |


### Horse Endpoints

| #  | Entity | Endpoint                                      | Creator |
|----|--------|-----------------------------------------------|---------|
| 33 | Horse  | `GET /get-owner-horses`                       | Ayman      |
| 34 | Horse  | `POST /assign/{horseId}`                      | Abrar   |
| 35 | Horse  | `GET /owner/horses-without-membership`        | Abrar       |
| 36 | Horse  | `PUT /gift/{horseId}/to/{newOwnerId}`         | Abrar


### Horse Owner Endpoints

| #  | Entity     | Endpoint                                      | Creator |
|----|------------|-----------------------------------------------|---------|
| 37 | HorseOwner | `POST /register`                              | Abrar   |
| 38 | HorseOwner | `GET /membership-invoice/pdf/{invoiceId}`     | Abrar   |


### Membership Endpoints

| #  | Entity      | Endpoint                                      | Creator |
|----|-------------|-----------------------------------------------|---------|
| 39 | Membership  | `GET /get`                                    | Abrar    |
| 40 | Membership  | `POST /request-membership/{stableId}`         | Abrar - Ayman -Abeer      |
| 41 | Membership  | `PUT /renew-membership/{id}`                  | Abrar - Ayman -Abeer   |
| 42 | Membership  | `GET /get-expired-memberships`                | Abrar      |

### Payment Endpoints

| #  | Entity   | Endpoint                                                  | Creator |
|----|----------|-----------------------------------------------------------|---------|
| 43 | Payment  | `POST /course-enrollment-card/{courseEnrollmentId}`      | Ayman      |
| 44 | Payment  | `GET /get-status`                                         | Ayman      |
| 45 | Payment  | `POST /membership/{membershipId}`                        | Abrar   |

### Stable Endpoints

| #  | Entity  | Endpoint                                  | Creator |
|----|---------|-------------------------------------------|---------|
| 46 | Stable  | `GET /get-stable-by-id/{stable_Id}`       | Abeer   |
| 47 | Stable  | `POST /add`                               | Abeer   |
| 48 | Stable  | `GET /get-available-stables`              | Ayman       |

### Stable Owner Endpoints

| #  | Entity       | Endpoint                                      | Creator |
|----|--------------|-----------------------------------------------|---------|
| 49 | StableOwner  | `GET /get-stable-owner`                       | Abeer   |
| 50 | StableOwner  | `POST /register`                              | Abeer      |
| 51 | StableOwner  | `GET /get-pending-invoices{stableId}`         | Ayman      |


### Stable Review Endpoints

| #  | Entity        | Endpoint                                  | Creator |
|----|---------------|-------------------------------------------|---------|
| 52 | StableReview  | `GET /stables/{stableId}/reviews`         | Abrar   |
| 53 | StableReview  | `POST /add/{stableId}`                    | Abrar      |
| 54 | StableReview  | `GET /reviews/sorted`                     | Abrar     |

### Staff Manager Endpoints

| #  | Entity       | Endpoint                                                     | Creator |
|----|--------------|--------------------------------------------------------------|---------|
| 55 | StaffManager | `POST /move-trainer/{trainer_Id}/to-stable/{stable_Id}`     | Abeer   |
| 56 | StaffManager | `POST /move-breeder/{breeder_Id}/to-stable/{stable_Id}`     | Abeer   |
| 57 | StaffManager | `POST /move-veterinary/{veterinary_Id}/to-stable/{stable_Id}`| Abeer  |
| 58 | StaffManager | `PUT /assign-breeder/{breeder_Id}/to-horse/{horse_Id}`      | Abeer   |
| 59 | StaffManager | `PUT /assign-veterinary/{veterinary_Id}/to-horse/{horse_Id}`| Abeer   |
| 60 | StaffManager | `GET /all-horse-to-veterinary/{veterinary_Id}`              | Abeer   |
| 61 | StaffManager | `GET /all-horse-to-breeder/{breeder_Id}`                    | Abeer   |
| 62 | StaffManager | `POST /veterinary/visit/{horse_Id}/{membershipId}`          | Abeer   |
| 63 | StaffManager | `PUT /veterinary/visit/fit/{visit_Id}`                      | Abeer   |  
| 64 | StaffManager | `PUT /veterinary/visit/un-fit/{visit_Id}`                   | Abeer   |


### Trainer Endpoints

| #  | Entity  | Endpoint                                                          | Creator |
|----|---------|-------------------------------------------------------------------|---------|
| 64 | Trainer | `GET /get/{trainer_Id}`                                           | Abeer   |
| 65 | Trainer | `GET /search-by-name/{fullName}`                                  | Abeer   |
| 66 | Trainer | `POST /add-trainer-to-stable/{stable_Id}`                         | Abeer   |
| 67 | Trainer | `PUT /update-trainer/{trainer_Id}/by-stable/{stable_Id}`          | Abeer   |
| 68 | Trainer | `DELETE /delete-trainer/{trainer_Id}`                             | Abeer   |
| 69 | Trainer | `GET /get-top-rated-trainer`                                      | Abrar   |
| 70 | Trainer | `GET /get-top-rated-trainer-of-stable/{stableId}`                 | —       |

### Veterinary Endpoints

| #  | Entity     | Endpoint                                              | Creator |
|----|------------|-------------------------------------------------------|---------|
| 71 | Veterinary | `GET /get/{veterinary_Id}`                            | Abeer   |
| 72 | Veterinary | `GET /search-by-name/{fullName}`                      | —       |
| 73 | Veterinary | `POST /add/{stable_Id}`                               | Abeer   |
| 74 | Veterinary | `PUT /update/{stable_Id}/{veterinary_Id}`             | Abeer   |
| 75 | Veterinary | `DELETE /delete/{veterinary_Id}`                      | Abeer   |

### Veterinary Visit Endpoints

| #  | Entity         | Endpoint                                  | Creator |
|----|----------------|-------------------------------------------|---------|
| 76 | VeterinaryVisit | `GET /get/{veterinaryVisit_Id}`          | Abeer   |
| 77 | VeterinaryVisit | `DELETE /delete/{veterinaryVisit_Id}`   | Abeer   |


## Contact Information  
For questions or support:  
- **Email**: alotaibi.s.abrar@gmail.com
- **Email** ayman.f.alharbi@gmail.com
- **Email** Aboor.1048@gmail.com
## LinkedIn
- **Abrar Saud** [LinkedIn](https://www.linkedin.com/in/abrar-saud/)
- **Ayman Alharbi** https://www.linkedin.com/in/ayman-alharbi1
- **Abeer secondName** https://www.linkedin.com/in/abeer-alhawsawi-516b282b8
