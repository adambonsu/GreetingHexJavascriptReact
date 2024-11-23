import os
import shutil

def clean_android_build(directory):
    build_dir = os.path.join(directory, 'app', 'build')
    if os.path.exists(build_dir):
        print(f"Removing build directory: {build_dir}")
        shutil.rmtree(build_dir)
    else:
        print(f"Build directory not found: {build_dir}")

if __name__ == "__main__":
    android_directory = os.environ.get('ANDROID_DIR', '')
    if not android_directory:
        print("ANDROID_DIR environment variable not set")
        exit(1)
    clean_android_build(android_directory)
