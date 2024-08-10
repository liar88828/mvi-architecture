package com.tutor.mvi_tutor.persentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.tutor.mvi_tutor.R
import com.tutor.mvi_tutor.persentation.state.HomeState
import com.tutor.mvi_tutor.ui.theme.PrimaryLightColor
import com.tutor.mvi_tutor.ui.theme.fontItim

@Composable
fun HomeScreen(
	navController: NavHostController,
	homeState: HomeState,
	modifier: Modifier = Modifier,
) {
	Scaffold(
		floatingActionButton = {
			FloatingActionButton(
				{}
			) {
				Icon(
					imageVector = Icons.Default.Add,
					contentDescription = "Add Icons"
				)
			}
		}
	) { paddingValues ->
		Column(
			modifier
				.padding(paddingValues)
				.fillMaxWidth()
		) {
			Column(
				modifier.fillMaxWidth()
			) {
				Box(
					modifier
						.fillMaxWidth()
						.height(70.dp)
						.background(
							color = PrimaryLightColor
						)
				) {
					Box(
						modifier
							.align(Alignment.BottomStart)
							.offset(
								x = 20.dp,
								y = 30.dp
							)
					) {

						Image(
							painter = painterResource(R.drawable.ic_launcher_foreground),
							contentDescription = "Image avatar",
							modifier
								.height(80.dp)
								.background(
									color = Color.White,
									shape = CircleShape
								)
								.border(
									width = 2.dp,
									color = MaterialTheme.colorScheme.primary,
									shape = CircleShape
								)
						)
					}
				}

			}

			Column(
				modifier
					.fillMaxWidth()
					.padding(
						top = 40.dp, start = 10.dp,
						end = 10.dp
					)
			) {
				Row(
					modifier
						.fillMaxWidth()
				) {
					Text(
						"My Task",
//						fontFamily = fontItim,
						fontSize = 22.sp
					)
				}
				HorizontalDivider(modifier.padding(vertical = 5.dp))
				LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp)) {
					items(2) {
						Text(
							text = "Complete Task",
							color = Color.Black
						)
					}

				}
			}
		}
	}

}

@Preview
@Composable
private fun HomeScreenPrev() {
	HomeScreen(
		navController = NavHostController(LocalContext.current),
		homeState = HomeState()
	)
}