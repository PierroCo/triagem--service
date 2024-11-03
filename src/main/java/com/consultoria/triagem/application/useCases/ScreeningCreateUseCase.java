//package com.consultoria.triagem.application.useCases;
//
//import com.consultoria.triagem.application.domain.screening.Screening;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.UUID;
//
//@Component
//public class ScreeningCreateUseCase {
//
//	public OutputTemp execute(final Input input){
//       final var newScreening = Screening.newScreening(
//               input.profession(), input.linkedin(), input.activityArea(), input.currentPosition(),
//               input.areaOfInterest(), input.desiredPosition(), input.timeToAchieveGoal());
//
//       final var screening ="Teste Temp";
//       return OutputTemp.from(screening);
//    }
//
//    public record Input(UUID userId, String profession, String linkedin, String activityArea,
//                        String currentPosition, String areaOfInterest, String desiredPosition, Date timeToAchieveGoal){
//    }
//    public record Output(UUID id, UUID userId, String profession, String linkedin, String activityArea,
//                        String currentPosition, String areaOfInterest, String desiredPosition, Date timeToAchieveGoal){
//        public static Output from (Screening screening){
//            return new Output(screening.getId(), screening.getUserId(), screening.getProfession(), screening.getLinkedin(),
//                    screening.getActivityArea(),screening.getCurrentPosition(), screening.getAreaOfInterest(),  screening.getDesiredPosition(),
//                    screening.getTimeToAchieveGoal());
//        }
//    }
//
//    public record OutputTemp(String output){
//        public static OutputTemp from (String teste){
//            return new OutputTemp("Teste Temp");
//        }
//    };
//}
