package com.smartchat.conversai.ui.assistants

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.smartchat.conversai.R
import com.smartchat.conversai.common.Constants
import com.smartchat.conversai.common.components.AppBar
import com.smartchat.conversai.common.components.AssistantCard
import com.smartchat.conversai.common.components.ChipItem
import com.smartchat.conversai.data.model.AiAssistantModel
import com.smartchat.conversai.data.model.AiAssistantsModel
import com.smartchat.conversai.ui.theme.Green
import com.smartchat.conversai.ui.theme.PastelAqua
import com.smartchat.conversai.ui.theme.PastelBlue
import com.smartchat.conversai.ui.theme.PastelCoral
import com.smartchat.conversai.ui.theme.PastelGreen
import com.smartchat.conversai.ui.theme.PastelLavender
import com.smartchat.conversai.ui.theme.PastelLilac
import com.smartchat.conversai.ui.theme.PastelOrange
import com.smartchat.conversai.ui.theme.PastelPink
import com.smartchat.conversai.ui.theme.PastelPurple
import com.smartchat.conversai.ui.theme.PastelRed
import com.smartchat.conversai.ui.theme.PastelTeal
import com.smartchat.conversai.ui.theme.PastelYellow
import com.smartchat.conversai.ui.theme.Urbanist

@Composable
fun AiAssistantsScreen(
    navigateToChat: (String, String, List<String>) -> Unit,
    viewModel: AiAssistantsViewModel = hiltViewModel()
) {

    LaunchedEffect(true) {
        viewModel.getProVersion()
    }

    val assistantList: List<AiAssistantsModel> = listOf(


        AiAssistantsModel(
            title = stringResource(R.string.nutrition), assistant = listOf(
                AiAssistantModel(
                    image = R.drawable.meal_plan,
                    color = PastelPink,
                    name = stringResource(R.string.meal_plan),
                    description = stringResource(R.string.meal_plan_description),
                    role = Constants.Nutrition.MEAL_PLAN,
                    example = listOf(
                        stringResource(R.string.meal_plan_example1),
                        stringResource(R.string.meal_plan_example2),
                        stringResource(R.string.meal_plan_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.diet,
                    color = PastelYellow,
                    name = stringResource(R.string.diet),
                    description = stringResource(R.string.diet_description),
                    role = Constants.Nutrition.DIET,
                    example = listOf(
                        stringResource(R.string.diet_example1),
                        stringResource(R.string.diet_example2),
                        stringResource(R.string.diet_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.vegetarian,
                    color = PastelBlue,
                    name = stringResource(R.string.vegetarian),
                    description = stringResource(R.string.vegetarian_description),
                    role = Constants.Nutrition.VEGETARIAN,
                    example = listOf(
                        stringResource(R.string.vegetarian_example1),
                        stringResource(R.string.vegetarian_example2),
                        stringResource(R.string.vegetarian_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.cooking,
                    color = PastelGreen,
                    name = stringResource(R.string.cooking),
                    description = stringResource(R.string.cooking_description),
                    role = Constants.Nutrition.COOKING_RECIPES,
                    example = listOf(
                        stringResource(R.string.cooking_example1),
                        stringResource(R.string.cooking_example2),
                        stringResource(R.string.cooking_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.harmful,
                    color = PastelOrange,
                    name = stringResource(R.string.harmful),
                    description = stringResource(R.string.harmful_description),
                    role = Constants.Nutrition.HARMFUL_PRODUCTS,
                    example = listOf(
                        stringResource(R.string.harmful_example1),
                        stringResource(R.string.harmful_example2),
                        stringResource(R.string.harmful_example3)
                    )
                ),
            )
        ),

        AiAssistantsModel(
            title = stringResource(R.string.psychology), assistant = listOf(
                AiAssistantModel(
                    image = R.drawable.psychology,
                    color = PastelRed,
                    name = stringResource(R.string.emotionalwellbeing),
                    description = stringResource(R.string.emotionalwellbeing_description),
                    role = Constants.Psychology.EMOTIONALWELLBEING,
                    example = listOf(
                        stringResource(R.string.emotionalwellbeing_example1),
                        stringResource(R.string.emotionalwellbeing_example2),
                        stringResource(R.string.emotionalwellbeing_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.psychotherapy,
                    color = PastelTeal,
                    name = stringResource(R.string.psychotherapy),
                    description = stringResource(R.string.psychotherapy_description),
                    role = Constants.Psychology.PSYCHOTHERAPY,
                    example = listOf(
                        stringResource(R.string.psychotherapy_example1),
                        stringResource(R.string.psychotherapy_example2),
                        stringResource(R.string.psychotherapy_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.personal,
                    color = PastelGreen,
                    name = stringResource(R.string.personal_development),
                    description = stringResource(R.string.personal_development_description),
                    role = Constants.Psychology.PERSONAL_DEVELOPMENT,
                    example = listOf(
                        stringResource(R.string.personal_development_example1),
                        stringResource(R.string.personal_development_example2),
                        stringResource(R.string.personal_development_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.relationships,
                    color = PastelYellow,
                    name = stringResource(R.string.relationships),
                    description = stringResource(R.string.relationships_description),
                    role = Constants.Psychology.PSYCHOLOGY_OF_RELATIONSHIPS,
                    example = listOf(
                        stringResource(R.string.relationships_example1),
                        stringResource(R.string.relationships_example2),
                        stringResource(R.string.relationships_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.selfconsciousness,
                    color = PastelPink,
                    name = stringResource(R.string.selfconsciousness),
                    description = stringResource(R.string.selfconsciousness_description),
                    role = Constants.Psychology.PSYCHOLOGY_OF_SELFCONSCIOUSNESS,
                    example = listOf(
                        stringResource(R.string.selfconsciousness_example1),
                        stringResource(R.string.selfconsciousness_example2),
                        stringResource(R.string.selfconsciousness_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.mental_health,
                    color = PastelLavender,
                    name = stringResource(R.string.mental_health),
                    description = stringResource(R.string.mental_health_description),
                    role = Constants.Psychology.MENTAL_HEALTH,
                    example = listOf(
                        stringResource(R.string.mental_health_example1),
                        stringResource(R.string.mental_health_example2),
                        stringResource(R.string.mental_health_example3)
                    )
                )
            )
        ),

        AiAssistantsModel(
            title = stringResource(R.string.writing), assistant = listOf(
                AiAssistantModel(
                    image = R.drawable.memo,
                    color = PastelGreen,
                    name = stringResource(R.string.write_article),
                    description = stringResource(R.string.write_article_description),
                    role = Constants.Writing.WRITE_ARTICLE,
                    example = listOf(
                        stringResource(R.string.write_article_example1),
                        stringResource(R.string.write_article_example2),
                        stringResource(R.string.write_article_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.cap,
                    color = PastelPurple,
                    name = stringResource(R.string.academic_writer),
                    description = stringResource(R.string.academic_writer_description),
                    role = Constants.Writing.ACADEMIC_WRITER,
                    example = listOf(
                        stringResource(R.string.academic_writer_example1),
                        stringResource(R.string.academic_writer_example2),
                        stringResource(R.string.academic_writer_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.page_facing_up,
                    color = PastelRed,
                    name = stringResource(R.string.summarize),
                    description = stringResource(R.string.summarize_description),
                    role = Constants.Writing.SUMMARIZE,
                    example = listOf(
                        stringResource(R.string.summarize_example1),
                        stringResource(R.string.summarize_example2),
                        stringResource(R.string.summarize_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.earth,
                    color = PastelOrange,
                    name = stringResource(R.string.translate_language),
                    description = stringResource(R.string.translate_language_description),
                    role = Constants.Writing.TRANSLATE_LANGUAGE,
                    example = listOf(
                        stringResource(R.string.translate_language_example1),
                        stringResource(R.string.translate_language_example2),
                        stringResource(R.string.translate_language_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.search,
                    color = PastelPink,
                    name = stringResource(R.string.plagiarism_checker),
                    description = stringResource(R.string.plagiarism_checker_description),
                    role = Constants.Writing.PLAGIARISM_CHECKER,
                    example = listOf(
                        stringResource(R.string.plagiarism_checker_example1),
                        stringResource(R.string.plagiarism_checker_example2),
                        stringResource(R.string.plagiarism_checker_example3)
                    )
                ),
            )
        ),


        AiAssistantsModel(
            title = stringResource(R.string.fitness), assistant = listOf(
                AiAssistantModel(
                    image = R.drawable.training_programs,
                    color = PastelPink,
                    name = stringResource(R.string.training_programs),
                    description = stringResource(R.string.training_programs_description),
                    role = Constants.Fitness.TRAINING_PROGRAMS,
                    example = listOf(
                        stringResource(R.string.training_programs_example1),
                        stringResource(R.string.training_programs_example2),
                        stringResource(R.string.training_programs_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.exercises,
                    color = PastelYellow,
                    name = stringResource(R.string.exercises),
                    description = stringResource(R.string.exercises_description),
                    role = Constants.Fitness.EXERCISES,
                    example = listOf(
                        stringResource(R.string.exercises_example1),
                        stringResource(R.string.exercises_example2),
                        stringResource(R.string.exercises_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.nutrition_f,
                    color = PastelBlue,
                    name = stringResource(R.string.nutrition_f),
                    description = stringResource(R.string.nutrition_f_description),
                    role = Constants.Fitness.NUTRITION_F,
                    example = listOf(
                        stringResource(R.string.nutrition_f_example1),
                        stringResource(R.string.nutrition_f_example2),
                        stringResource(R.string.nutrition_f_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.home_workouts,
                    color = PastelGreen,
                    name = stringResource(R.string.home_workouts),
                    description = stringResource(R.string.home_workouts_description),
                    role = Constants.Fitness.HOME_WORKOUTS,
                    example = listOf(
                        stringResource(R.string.home_workouts_example1),
                        stringResource(R.string.home_workouts_example2),
                        stringResource(R.string.home_workouts_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.health_f,
                    color = PastelPink,
                    name = stringResource(R.string.health_f),
                    description = stringResource(R.string.health_f_description),
                    role = Constants.Fitness.HEALTH_F,
                    example = listOf(
                        stringResource(R.string.health_f_example1),
                        stringResource(R.string.health_f_example2),
                        stringResource(R.string.health_f_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.weight_loss,
                    color = PastelOrange,
                    name = stringResource(R.string.weight_loss),
                    description = stringResource(R.string.weight_loss_description),
                    role = Constants.Fitness.WEIGHT_LOSS,
                    example = listOf(
                        stringResource(R.string.weight_loss_example1),
                        stringResource(R.string.weight_loss_example2),
                        stringResource(R.string.weight_loss_example3)
                    )
                ),
            )
        ),


        AiAssistantsModel(
            title = stringResource(R.string.creative), assistant = listOf(
                AiAssistantModel(
                    image = R.drawable.musical,
                    color = PastelYellow,
                    name = stringResource(R.string.song_lyrics),
                    description = stringResource(R.string.song_lyrics_description),
                    role = Constants.Creative.SONG_LYRICS,
                    example = listOf(
                        stringResource(R.string.song_lyrics_example1),
                        stringResource(R.string.song_lyrics_example2),
                        stringResource(R.string.song_lyrics_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.open_book,
                    color = PastelAqua,
                    name = stringResource(R.string.storyteller),
                    description = stringResource(R.string.storyteller_description),
                    role = Constants.Creative.STORYTELLER,
                    example = listOf(
                        stringResource(R.string.storyteller_example1),
                        stringResource(R.string.storyteller_example2),
                        stringResource(R.string.storyteller_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.scroll,
                    color = PastelGreen,
                    name = stringResource(R.string.poems),
                    description = stringResource(R.string.poems_description),
                    role = Constants.Creative.POEMS,
                    example = listOf(
                        stringResource(R.string.poems_example1),
                        stringResource(R.string.poems_example2),
                        stringResource(R.string.poems_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.clapper,
                    color = PastelPink,
                    name = stringResource(R.string.movie_script),
                    description = stringResource(R.string.movie_script_description),
                    role = Constants.Creative.MOVIE_SCRIPT,
                    example = listOf(
                        stringResource(R.string.movie_script_example1),
                        stringResource(R.string.movie_script_example2),
                        stringResource(R.string.movie_script_example3)
                    )
                )
            )
        ),


        AiAssistantsModel(
            title = stringResource(R.string.businesse), assistant = listOf(
                AiAssistantModel(
                    image = R.drawable.startups,
                    color = PastelGreen,
                    name = stringResource(R.string.startups),
                    description = stringResource(R.string.startups_description),
                    role = Constants.Businesse.STARTUPS,
                    example = listOf(
                        stringResource(R.string.startups_example1),
                        stringResource(R.string.startups_example2),
                        stringResource(R.string.startups_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.finance,
                    color = PastelRed,
                    name = stringResource(R.string.finance),
                    description = stringResource(R.string.finance_description),
                    role = Constants.Businesse.FINANCE,
                    example = listOf(
                        stringResource(R.string.finance_example1),
                        stringResource(R.string.finance_example2),
                        stringResource(R.string.finance_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.marketing,
                    color = PastelBlue,
                    name = stringResource(R.string.marketing),
                    description = stringResource(R.string.marketing_description),
                    role = Constants.Businesse.MARKETING,
                    example = listOf(
                        stringResource(R.string.marketing_example1),
                        stringResource(R.string.marketing_example2),
                        stringResource(R.string.marketing_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.managment,
                    color = PastelLavender,
                    name = stringResource(R.string.managment),
                    description = stringResource(R.string.managment_description),
                    role = Constants.Businesse.MANAGMENT,
                    example = listOf(
                        stringResource(R.string.managment_example1),
                        stringResource(R.string.managment_example2),
                        stringResource(R.string.managment_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.innovation,
                    color = PastelYellow,
                    name = stringResource(R.string.innovation),
                    description = stringResource(R.string.innovation_description),
                    role = Constants.Businesse.INNOVATION,
                    example = listOf(
                        stringResource(R.string.innovation_example1),
                        stringResource(R.string.innovation_example2),
                        stringResource(R.string.innovation_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.smallbusiness,
                    color = PastelPink,
                    name = stringResource(R.string.smallbusiness),
                    description = stringResource(R.string.smallbusiness_description),
                    role = Constants.Businesse.SMALLBUSINESS,
                    example = listOf(
                        stringResource(R.string.smallbusiness_example1),
                        stringResource(R.string.smallbusiness_example2),
                        stringResource(R.string.smallbusiness_example3)
                    )
                ),
            )
        ),


        AiAssistantsModel(
            title = stringResource(R.string.business), assistant = listOf(
                AiAssistantModel(
                    image = R.drawable.envelope,
                    color = PastelPurple,
                    name = stringResource(R.string.email_writer),
                    description = stringResource(R.string.email_writer_description),
                    role = Constants.Business.EMAIL_WRITER,
                    example = listOf(
                        stringResource(R.string.email_writer_example1),
                        stringResource(R.string.email_writer_example2),
                        stringResource(R.string.email_writer_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.page_with_curl,
                    color = PastelOrange,
                    name = stringResource(R.string.answer_interviewer),
                    description = stringResource(R.string.answer_interviewer_description),
                    role = Constants.Business.ANSWER_INTERVIEWER,
                    example = listOf(
                        stringResource(R.string.answer_interviewer_example1),
                        stringResource(R.string.answer_interviewer_example2),
                        stringResource(R.string.answer_interviewer_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.briefcase,
                    color = PastelLilac,
                    name = stringResource(R.string.job_post),
                    description = stringResource(R.string.job_post_description),
                    role = Constants.Business.JOB_POST,
                    example = listOf(
                        stringResource(R.string.job_post_example1),
                        stringResource(R.string.job_post_example2),
                        stringResource(R.string.job_post_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.star,
                    color = PastelAqua,
                    name = stringResource(R.string.advertisement),
                    description = stringResource(R.string.advertisement_description),
                    role = Constants.Business.ADVERTISEMENT,
                    example = listOf(
                        stringResource(R.string.advertisement_example1),
                        stringResource(R.string.advertisement_example2),
                        stringResource(R.string.advertisement_example3)
                    )
                )
            )
        ),

        AiAssistantsModel(
            title = stringResource(R.string.love), assistant = listOf(
                AiAssistantModel(
                    image = R.drawable.love,
                    color = PastelBlue,
                    name = stringResource(R.string.love_advice),
                    description = stringResource(R.string.love_advice_description),
                    role = Constants.Love.LOVE_ADVICE,
                    example = listOf(
                        stringResource(R.string.love_advice_example1),
                        stringResource(R.string.love_advice_example2),
                        stringResource(R.string.love_advice_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.lovem,
                    color = PastelPurple,
                    name = stringResource(R.string.love_confes),
                    description = stringResource(R.string.love_confes_description),
                    role = Constants.Love.LOVE_CONVES,
                    example = listOf(
                        stringResource(R.string.love_confes_example1),
                        stringResource(R.string.love_confes_example2),
                        stringResource(R.string.love_confes_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.love2,
                    color = PastelGreen,
                    name = stringResource(R.string.how_to_meet),
                    description = stringResource(R.string.how_to_meet_description),
                    role = Constants.Love.HOW_TO_MEET,
                    example = listOf(
                        stringResource(R.string.how_to_meet_example1),
                        stringResource(R.string.how_to_meet_example2),
                        stringResource(R.string.how_to_meet_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.parting,
                    color = PastelAqua,
                    name = stringResource(R.string.parting),
                    description = stringResource(R.string.parting_description),
                    role = Constants.Love.PARTING,
                    example = listOf(
                        stringResource(R.string.parting_example1),
                        stringResource(R.string.parting_example2),
                        stringResource(R.string.parting_example3)
                    )
                )




            )
        ),
        AiAssistantsModel(
            title = stringResource(R.string.social_media), assistant = listOf(
                AiAssistantModel(
                    image = R.drawable.linkedin,
                    color = PastelAqua,
                    name = stringResource(R.string.linkedin),
                    description = stringResource(R.string.linkedin_description),
                    role = Constants.SocialMedia.LINKEDIN,
                    example = listOf(
                        stringResource(R.string.linkedin_example1),
                        stringResource(R.string.linkedin_example2),
                        stringResource(R.string.linkedin_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.instagram,
                    color = PastelYellow,
                    name = stringResource(R.string.instagram),
                    description = stringResource(R.string.instagram_description),
                    role = Constants.SocialMedia.INSTAGRAM,
                    example = listOf(
                        stringResource(R.string.instagram_example1),
                        stringResource(R.string.instagram_example2),
                        stringResource(R.string.instagram_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.twitter,
                    color = PastelBlue,
                    name = stringResource(R.string.twitter),
                    description = stringResource(R.string.twitter_description),
                    role = Constants.SocialMedia.TWITTER,
                    example = listOf(
                        stringResource(R.string.twitter_example1),
                        stringResource(R.string.twitter_example2),
                        stringResource(R.string.twitter_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.tiktok,
                    color = PastelTeal,
                    name = stringResource(R.string.tiktok),
                    description = stringResource(R.string.tiktok_description),
                    role = Constants.SocialMedia.TIKTOK,
                    example = listOf(
                        stringResource(R.string.tiktok_example1),
                        stringResource(R.string.tiktok_example2),
                        stringResource(R.string.tiktok_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.facebook,
                    color = PastelLavender,
                    name = stringResource(R.string.facebook),
                    description = stringResource(R.string.facebook_description),
                    role = Constants.SocialMedia.FACEBOOK,
                    example = listOf(
                        stringResource(R.string.facebook_example1),
                        stringResource(R.string.facebook_example2),
                        stringResource(R.string.facebook_example3)
                    )
                )
            )
        ),
        AiAssistantsModel(
            title = stringResource(R.string.developer), assistant = listOf(
                AiAssistantModel(
                    image = R.drawable.laptop,
                    color = PastelGreen,
                    name = stringResource(R.string.write_code),
                    description = stringResource(R.string.write_code_description),
                    role = Constants.Developer.WRITE_CODE,
                    example = listOf(
                        stringResource(R.string.write_code_example1),
                        stringResource(R.string.write_code_example2),
                        stringResource(R.string.write_code_example3)
                    )

                ),
                AiAssistantModel(
                    image = R.drawable.explain_code1,
                    color = PastelRed,
                    name = stringResource(R.string.explain_code),
                    description = stringResource(R.string.explain_code_description),
                    role = Constants.Developer.EXPLAIN_CODE,
                    example = listOf(
                        stringResource(R.string.explain_code_example1),
                        stringResource(R.string.explain_code_example2),
                        stringResource(R.string.explain_code_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.startwork,
                    color = PastelYellow,
                    name = stringResource(R.string.start),
                    description = stringResource(R.string.start_description),
                    role = Constants.Developer.START,
                    example = listOf(
                        stringResource(R.string.start_example1),
                        stringResource(R.string.start_example2),
                        stringResource(R.string.start_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.explain_code,
                    color = PastelBlue,
                    name = stringResource(R.string.work1),
                    description = stringResource(R.string.work1_description),
                    role = Constants.Developer.WORK,
                    example = listOf(
                        stringResource(R.string.work1_example1),
                        stringResource(R.string.work1_example2),
                        stringResource(R.string.work1_example3)
                    )
                )
            )
        ),
        AiAssistantsModel(
            title = stringResource(R.string.personal), assistant = listOf(
                AiAssistantModel(
                    image = R.drawable.cake,
                    color = PastelYellow,
                    name = stringResource(R.string.birtday),
                    description = stringResource(R.string.birtday_description),
                    role = Constants.Personal.BIRTHDAY,
                    example = listOf(
                        stringResource(R.string.birtday_example1),
                        stringResource(R.string.birtday_example2),
                        stringResource(R.string.birtday_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.gift,
                    color = PastelCoral,
                    name = stringResource(R.string.apology),
                    description = stringResource(R.string.apology_description),
                    role = Constants.Personal.APOLOGY,
                    example = listOf(
                        stringResource(R.string.apology_example1),
                        stringResource(R.string.apology_example2),
                        stringResource(R.string.apology_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.envelope_arrow,
                    color = PastelBlue,
                    name = stringResource(R.string.invitation),
                    description = stringResource(R.string.invitation_description),
                    role = Constants.Personal.INVITATION,
                    example = listOf(
                        stringResource(R.string.invitation_example1),
                        stringResource(R.string.invitation_example2),
                        stringResource(R.string.invitation_example3)
                    )
                )
            )
        ),

        AiAssistantsModel(
            title = stringResource(R.string.other), assistant = listOf(
                AiAssistantModel(
                    image = R.drawable.balloon,
                    color = PastelPink,
                    name = stringResource(R.string.create_conversation),
                    description = stringResource(R.string.create_conversation_description),
                    role = Constants.Other.CREATE_CONVERSATION,
                    example = listOf(
                        stringResource(R.string.create_conversation_example1),
                        stringResource(R.string.create_conversation_example2),
                        stringResource(R.string.create_conversation_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.laugh,
                    color = PastelLavender,
                    name = stringResource(R.string.tell_joke),
                    description = stringResource(R.string.tell_joke_description),
                    role = Constants.Other.TELL_JOKE,
                    example = listOf(
                        stringResource(R.string.tell_joke_example1),
                        stringResource(R.string.tell_joke_example2),
                        stringResource(R.string.tell_joke_example3)
                    )
                ),
                AiAssistantModel(
                    image = R.drawable.food,
                    color = PastelRed,
                    name = stringResource(R.string.food_recipes),
                    description = stringResource(R.string.food_recipes_description),
                    role = Constants.Other.FOOD_RECIPES,
                    example = listOf(
                        stringResource(R.string.food_recipes_example1),
                        stringResource(R.string.food_recipes_example2),
                        stringResource(R.string.food_recipes_example3)
                    )
                ), AiAssistantModel(
                    image = R.drawable.leafy,
                    color = PastelGreen,
                    name = stringResource(R.string.diet_plan),
                    description = stringResource(R.string.diet_plan_description),
                    role = Constants.Other.DIET_PLAN,
                    example = listOf(
                        stringResource(R.string.diet_plan_example1),
                        stringResource(R.string.diet_plan_example2),
                        stringResource(R.string.diet_plan_example3)
                    )
                )
            )
        )
    )

    Box(Modifier.fillMaxSize()) {
        Column(
            Modifier
                .fillMaxSize()) {
            AppBar(
                onClickAction = {},
                image = R.drawable.app_icon,
                text = stringResource(R.string.ai_assistants),
                Green
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 10.dp)
            )
            {
                item {
                    ChipItem(
                        text = stringResource(R.string.all),
                        selected = viewModel.selectedValue.value == "",
                        onClick = {
                            viewModel.selectedValue.value = ""
                            viewModel.showVertical.value = false
                        }
                    )
                }
                items(assistantList) {
                    ChipItem(
                        text = it.title,
                        selected = viewModel.selectedValue.value == it.title,
                        onClick = {
                            viewModel.selectedValue.value = it.title

                            viewModel.verticalShowList.clear()
                            viewModel.verticalShowList.addAll(it.assistant)
                            viewModel.showVertical.value = true

                        }
                    )
                }
            }

            if (viewModel.showVertical.value) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                ) {
                    items(viewModel.verticalShowList)
                    {
                        AssistantCard(
                            image = it.image,
                            color = it.color,
                            name = it.name,
                            description = it.description,
                            onClick = { navigateToChat(it.name, it.role, it.example) }
                        )
                    }
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp)
                ) {
                    items(assistantList)
                    { aiAssistantList ->
 //                       if (aiAssistantList.title == stringResource(R.string.psychology)
 //                           && viewModel.isProVersion.value.not()) {
 //                           AdMobNative()
 //                       }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 5.dp, top = 15.dp)
                        ) {
                            Text(
                                text = aiAssistantList.title,
                                color = MaterialTheme.colors.surface,
                                style = TextStyle(
                                    fontSize = 25.sp,
                                    fontWeight = FontWeight.W700,
                                    fontFamily = Urbanist,
                                    lineHeight = 25.sp
                                ), modifier = Modifier.weight(1f)
                            )

                            IconButton(
                                onClick = {
                                    viewModel.selectedValue.value = aiAssistantList.title
                                    viewModel.verticalShowList.clear()
                                    viewModel.verticalShowList.addAll(aiAssistantList.assistant)
                                    viewModel.showVertical.value = true
                                },
                                modifier = Modifier
                                    .padding(end = 10.dp)
                                    .size(30.dp)
                            ) {

                                Icon(
                                    painter = painterResource(id = R.drawable.arrow_right),
                                    contentDescription = null,
                                    tint = Green
                                )
                            }


                        }

                        Spacer(modifier = Modifier.height(15.dp))

                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            items(aiAssistantList.assistant) {
                                AssistantCard(
                                    image = it.image,
                                    color = it.color,
                                    name = it.name,
                                    description = it.description,
                                    onClick = {
                                        navigateToChat(
                                            it.name,
                                            it.role,
                                            it.example
                                        )
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

// @Composable
// fun AdMobNative() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Bottom,
//   ) {
//        SmallNativeAd(adId = "ca-app-pub-4278583523990245/1438091863")
//    }
//}
