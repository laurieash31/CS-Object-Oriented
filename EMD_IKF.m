% YOU NEED TO MODIFY THE CODE IN THIS FILE IF YOU HAVE SELECTED TO IMPLEMENT
% Kalman Filter Identification Method
% I-KF, eye movement detection by Kalman Filter Model
function [eye_record,fixation_filtered_EMD,saccade_filtered_EMD,pursuit_detected_EMD,saccade_detected_EMD]= EMD_IKF(eye_record)

    display('>>> EMD_IKF starts..................................................................');
    
    duration_threshold = 100;
    
    %% I-KF algorithm
    fixation_counter = 0;
    saccade_counter = 0;
    pursuit_counter = 0;
    noise_counter = 0;
    
    for t=1:length(eye_record)
        
        % Initialize the state vector
        x_k = [eye_record(t).x_pos_measured_deg; eye_record(t).x_velocity_measured_deg];
        
        % Initialize the state transition matrix
        % NOT SURE HOW TO CALCULTE DELTA T FROM HIS VARIABLES!!!!!!
        A = [1 duration_threshold; 0 1];
        
        % Initialize state observation matrix
        H = [1 0];
        
        % Initialize state vectors initial values
        x_o = [eye_record(t).x_pos_measured_deg 0];
        y_o = [eye_record(t).y_pos_measured_deg 0];
        
        % Noise process covariance matrix
        Q_k = [power(0.5,2) 0; 0 power(0.5,2)];
        
        % Measurement noise covariance matrix
        R_k = power(0.5, 2);
        
        % Initial error covariance matrix
        P_o = [1 0; 0 1];
        
        
    end
    

    % Call the EMD_Merge for grouping and Merging Saccades, Fixations and Pursuits 
    [eye_record,fixation_filtered_EMD,saccade_filtered_EMD,pursuit_detected_EMD, saccade_detected_EMD] = EMD_Merge(eye_record);



return


  
