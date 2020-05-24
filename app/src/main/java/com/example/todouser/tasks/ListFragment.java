package com.example.todouser.tasks;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todouser.R;
import com.example.todouser.addedittask.AddEditTaskActivity;
import com.example.todouser.database.TaskEntry;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class ListFragment extends Fragment implements TaskAdapter.ItemClickListener {
    public ListFragment(){
        //
    }

    // Member variables for the adapter and RecyclerView
    private RecyclerView mRecyclerView;
    private TaskAdapter mAdapter;

    TaskActivityViewModel viewModel;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = ViewModelProviders.of(requireActivity()).get(TaskActivityViewModel.class);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    // Set the RecyclerView to its corresponding view
        mRecyclerView = getView().findViewById(R.id.recyclerViewTasks);

    // Set the layout for the RecyclerView to be a linear layout, which measures and
    // positions items within a RecyclerView into a linear list
    mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

    // Initialize the adapter and attach it to the RecyclerView
        mAdapter = new TaskAdapter(getContext(),this);
    mRecyclerView.setAdapter(mAdapter);

        DividerItemDecoration decoration = new DividerItemDecoration(getActivity().getApplicationContext(), DividerItemDecoration.VERTICAL);
    mRecyclerView.addItemDecoration(decoration);

        /*
         Add a touch helper to the RecyclerView to recognize when a user swipes to delete an item.
         An ItemTouchHelper enables touch behavior (like swipe and move) on each ViewHolder,
         and uses callbacks to signal when a user is performing these actions.
         */
    new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        // Called when a user swipes left or right on a ViewHolder
        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
            // Here is where you'll implement swipe to delete

            int position = viewHolder.getAdapterPosition();
            List<TaskEntry> todoList = mAdapter.getTasks();
            viewModel.deleteTask(todoList.get(position));
        }
    }).attachToRecyclerView(mRecyclerView);

        /*
         Set the Floating Action Button (FAB) to its corresponding View.
         Attach an OnClickListener to it, so that when it's clicked, a new intent will be created
         to launch the AddTaskActivity.
         */
    FloatingActionButton fabButton = getView().findViewById(R.id.fab);

    fabButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // Create a new intent to start an AddTaskActivity
            Intent addTaskIntent = new Intent(getActivity(), AddEditTaskActivity.class);
            startActivity(addTaskIntent);
        }
    });

    viewModel.getTasks().observe(getActivity(), new Observer<List<TaskEntry>>() {
        @Override
        public void onChanged(List<TaskEntry> taskEntries) {
            mAdapter.setTasks(taskEntries);
        }
    });
}

   public void onItemClickListener(int itemId) {
        // Launch AddTaskActivity adding the itemId as an extra in the intent
        Intent intent = new Intent(getActivity(), AddEditTaskActivity.class);
        intent.putExtra(AddEditTaskActivity.EXTRA_TASK_ID, itemId);
        startActivity(intent);
    }
}


