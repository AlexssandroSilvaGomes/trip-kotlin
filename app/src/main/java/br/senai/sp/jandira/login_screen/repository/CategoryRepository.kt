package br.senai.sp.jandira.login_screen.repository

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import br.senai.sp.jandira.login_screen.R
import br.senai.sp.jandira.login_screen.model.Category

class CategoryRepository {
    companion object {
        @Composable
        fun getCategories(): List<Category>{
            return listOf(
                Category(
                    id = 1,
                    name = "Mountain",
                    icon = painterResource(id = R.drawable.baseline_forest_24)
                ),
                Category(
                    id = 2,
                    name = "Beach",
                    icon = painterResource(id = R.drawable.baseline_beach_access_24)
                ),
                Category(
                    id = 3,
                    name = "Snow",
                    icon = painterResource(id = R.drawable.baseline_snowboarding_24)
                ),
                Category(
                    id = 4,
                    name = "Business",
                    icon = painterResource(id = R.drawable.baseline_business_center_24)
                )
            )
        }
    }
}